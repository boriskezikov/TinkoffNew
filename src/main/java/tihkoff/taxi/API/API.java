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

import static tihkoff.taxi.API.ApiCalls.changeOrderStatus;
import static tihkoff.taxi.API.ApiCalls.setUpTariff;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class API {

    private final TaxiOrderController taxiOrderController;

    @PostMapping
    public TaxiOrderDTO startSetOrder(@RequestBody PrimaryData primaryData) {
        TaxiOrderDTO taxiOrderDTO = new TaxiOrderDTO();
        ClientEntityDTO clientEntityDTO = new ClientEntityDTO();
        clientEntityDTO.setPhoneNumber(primaryData.getPhoneNumber());
        clientEntityDTO.setName(primaryData.getName());
        clientEntityDTO.setStatus(primaryData.getStatus());
        taxiOrderDTO.setClientEntity(clientEntityDTO);
        taxiOrderDTO = ApiCalls.searchDriver(taxiOrderDTO);
        taxiOrderDTO = setUpTariff(taxiOrderDTO);
        if(taxiOrderDTO.getTaxiDriverEntity() != null){
            taxiOrderDTO = changeOrderStatus(taxiOrderDTO,1);


        }

        taxiOrderController.addOrder(taxiOrderDTO);
        return taxiOrderDTO;
    }




        }




