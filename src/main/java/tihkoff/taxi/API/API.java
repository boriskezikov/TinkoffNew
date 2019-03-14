package tihkoff.taxi.API;


import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tihkoff.taxi.controller.TaxiOrderController;
import tihkoff.taxi.dto.ClientEntityDTO;
import tihkoff.taxi.dto.TaxiOrderDTO;
import tihkoff.taxi.mapper.ClientEntityMapper;
import tihkoff.taxi.repository.ClientRepository;
import tihkoff.taxi.services.TaxiOrderService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class API {

    private final TaxiOrderService taxiOrderService;
    private final ClientRepository clientRepository;
    private final ClientEntityMapper clientEntityMapper;
    private final OrderComputing orderComputing;


    @PostMapping
    public TaxiOrderDTO startSetOrder(@RequestBody PrimaryData primaryData) {
        TaxiOrderDTO taxiOrderDTO = new TaxiOrderDTO();
        ClientEntityDTO clientEntityDTO = new ClientEntityDTO();

        clientEntityDTO.setPhoneNumber(primaryData.getPhoneNumber());
        clientEntityDTO.setName(primaryData.getName());
        clientEntityDTO.setStatus(primaryData.getStatus());
        clientRepository.save(clientEntityMapper.clientEntityDTOmap(clientEntityDTO));

        taxiOrderDTO.setClientEntity(clientEntityDTO);

            taxiOrderDTO.setTaxiDriverEntity(orderComputing.searchDriver());

        taxiOrderDTO.setTariffEntity(orderComputing.searchTariff());
        taxiOrderDTO.setClientLocation(primaryData.location);
        taxiOrderDTO.setDestination(primaryData.destination);
        taxiOrderDTO.setStatus(1);


        taxiOrderService.createOrder(taxiOrderDTO);
        return taxiOrderDTO;
    }


}




