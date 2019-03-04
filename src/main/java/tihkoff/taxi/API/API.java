package tihkoff.taxi.API;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tihkoff.taxi.controller.*;
import tihkoff.taxi.domain.ClientEntity;
import tihkoff.taxi.dto.ClientEntityDTO;
import tihkoff.taxi.dto.TariffEntityDTO;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.dto.TaxiOrderDTO;

import java.lang.reflect.Executable;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api-call")
public class API {
    private final CarEntityController carEntityController;
    private final TariffEntityController tariffEntityController;
    private final ClientEntityController clientEntityController;
    private final RateEntityController rateEntityController;
    private final TaxiDriverController taxiDriverController;
    private final TaxiOrderController taxiOrderController;

    @PostMapping("/order/start")
    public TaxiOrderDTO startSetOrder(@RequestBody PrimaryData primaryData) {
        TaxiOrderDTO taxiOrderDTO = new TaxiOrderDTO();
        ClientEntityDTO clientEntityDTO = new ClientEntityDTO();
        clientEntityDTO.setPhoneNumber(primaryData.getPhoneNumber());
        clientEntityDTO.setName(primaryData.getName());
        clientEntityDTO.setStatus(primaryData.getStatus());
        taxiOrderDTO.setClientEntity(clientEntityDTO);
        taxiOrderDTO = searchDriver(taxiOrderDTO);
        taxiOrderDTO = setUpTariff(taxiOrderDTO);
        if(taxiOrderDTO.getTaxiDriverEntity() != null){
            taxiOrderDTO = changeOrderStatus(taxiOrderDTO,1);


        }

        taxiOrderController.addOrder(taxiOrderDTO);
        return taxiOrderDTO;
    }


    public TaxiOrderDTO searchDriver (TaxiOrderDTO taxiOrderDTO){
            List<TaxiDriverEntityDTO> drivers= taxiDriverController.getAll();
            for (int i = 0; i< drivers.size(); ++i){
                if(drivers.get(i).getStatus() == 0){
                   taxiOrderDTO.setTaxiDriverEntity(drivers.get(i));
                   break;
                }
            }
            return taxiOrderDTO;

        }

    public TaxiOrderDTO setUpTariff (TaxiOrderDTO taxiOrderDTO){
        List<TariffEntityDTO> tariff = tariffEntityController.getAll();
            for (int i = 0; i < tariff.size(); ++i)
                  {
                      taxiOrderDTO.setTariffEntity(tariff.get(i));
                      break;
            }
            return taxiOrderDTO;
        }

    public TaxiOrderDTO changeOrderStatus (TaxiOrderDTO taxiOrderDTO, Integer status){
        if (status==0|| status == 1|| status == 2){
            taxiOrderDTO.setStatus(status);
            return taxiOrderDTO;
        }

            return null;
        }



}
