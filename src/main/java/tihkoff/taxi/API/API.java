package tihkoff.taxi.API;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tihkoff.taxi.controller.*;
import tihkoff.taxi.dto.ClientEntityDTO;
import tihkoff.taxi.dto.TariffEntityDTO;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.dto.TaxiOrderDTO;
import tihkoff.taxi.mapper.ClientEntityMapper;
import tihkoff.taxi.repository.ClientRepository;
import java.util.List;




@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class API {

    private final TaxiOrderController taxiOrderController;
    private final TaxiDriverController taxiDriverController;
    private final  TariffEntityController tariffEntityController;
    private final ClientRepository clientRepository;
    private final ClientEntityMapper clientEntityMapper;


    public TaxiOrderDTO searchDriver(TaxiOrderDTO taxiOrderDTO) {
        List<TaxiDriverEntityDTO> drivers = taxiDriverController.getAll();
        for (int i = 0; i < drivers.size(); ++i) {
            if (drivers.get(i).getStatus() == 0) {
                taxiOrderDTO.setTaxiDriverEntity(drivers.get(i));
                break;
            }
        }
        return taxiOrderDTO;

    }

    public  TaxiOrderDTO setUpTariff(TaxiOrderDTO taxiOrderDTO) {
        List<TariffEntityDTO> tariff = tariffEntityController.getAll();
        // if (taxiOrderDTO.getDestination() - taxiOrderDTO.getClientLocation() > 10)
        for (int i = 0; i < tariff.size(); ++i) {
            taxiOrderDTO.setTariffEntity(tariff.get(i));
            break;
        }
        return taxiOrderDTO;
    }

    public TaxiOrderDTO changeOrderStatus(TaxiOrderDTO taxiOrderDTO, Integer status) {
        if (status == 0 || status == 1 || status == 2) {
            taxiOrderDTO.setStatus(status);
            return taxiOrderDTO;
        }
        return null;
    }

    @PostMapping
    public TaxiOrderDTO startSetOrder(@RequestBody PrimaryData primaryData) {
        TaxiOrderDTO taxiOrderDTO = new TaxiOrderDTO();
        ClientEntityDTO clientEntityDTO = new ClientEntityDTO();

        clientEntityDTO.setPhoneNumber(primaryData.getPhoneNumber());
        clientEntityDTO.setName(primaryData.getName());
        clientEntityDTO.setStatus(primaryData.getStatus());
        clientRepository.save(clientEntityMapper.clientEntityDTOmap(clientEntityDTO));

        taxiOrderDTO.setClientEntity(clientEntityDTO);
        taxiOrderDTO = searchDriver(taxiOrderDTO);
        taxiOrderDTO = setUpTariff(taxiOrderDTO);
        taxiOrderDTO.setClientLocation(primaryData.location);
        taxiOrderDTO.setDestination(primaryData.destination);

        if(taxiOrderDTO.getTaxiDriverEntity() != null){
            taxiOrderDTO = changeOrderStatus(taxiOrderDTO,1);

        }

        taxiOrderController.addOrder(taxiOrderDTO);
        return taxiOrderDTO;
    }




        }




