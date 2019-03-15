package tihkoff.taxi.API;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tihkoff.taxi.dto.ClientEntityDTO;
import tihkoff.taxi.dto.RateEntityDTO;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.dto.TaxiOrderDTO;
import tihkoff.taxi.mapper.ClientEntityMapper;
import tihkoff.taxi.repository.ClientRepository;
import tihkoff.taxi.services.ClientService;
import tihkoff.taxi.services.TaxiDriverService;
import tihkoff.taxi.services.TaxiOrderService;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class API {

    private final TaxiOrderService taxiOrderService;
    private final ClientRepository clientRepository;
    private final ClientEntityMapper clientEntityMapper;
    private final OrderComputing orderComputing;
    private final ClientService clientService;
    private final TaxiDriverService taxiDriverService;
    public final Adder adder;

    @PostMapping
    public TaxiOrderDTO startSetOrder(@RequestBody PrimaryData primaryData) {
        TaxiOrderDTO taxiOrderDTO = new TaxiOrderDTO();
        ClientEntityDTO clientEntityDTO = new ClientEntityDTO();
        RateEntityDTO rateEntityDTO = new RateEntityDTO();


        clientEntityDTO = clientService.getByPhone(primaryData.getPhoneNumber());
        clientEntityDTO.setPhoneNumber(primaryData.getPhoneNumber());
        clientEntityDTO.setStatus(primaryData.getStatus());
        clientEntityDTO.setName("stranger");
        clientRepository.save(clientEntityMapper.clientEntityDTOmap(clientEntityDTO));


        taxiOrderDTO.setClientEntity(clientEntityDTO);
        TaxiDriverEntityDTO taxiDriverEntityDTO = orderComputing.searchDriver();
        taxiOrderDTO.setTaxiDriverEntity(taxiDriverEntityDTO);
        taxiOrderDTO.setTariffEntity(orderComputing.searchTariff());
        taxiOrderDTO.setClientLocation(primaryData.location);
        taxiOrderDTO.setDestination(primaryData.destination);
        taxiOrderDTO.setStatus(1);
        taxiOrderDTO.setRateEntity(rateEntityDTO);

        taxiDriverService.editDriver(taxiDriverEntityDTO, taxiDriverEntityDTO.getId());


        return taxiOrderService.createOrder(taxiOrderDTO);

    }

    @DeleteMapping("{id}")
    public String finishOrder(@PathVariable("id") Long id) {
        TaxiOrderDTO taxiOrderDTO = taxiOrderService.getByOrderID(id);
        taxiOrderDTO.setStatus(0);
        taxiOrderService.editOrder(taxiOrderDTO, id);
        taxiOrderService.getByOrderID(id).getTaxiDriverEntity().setStatus(0);

        TaxiDriverEntityDTO taxiDriverEntityDTO = taxiOrderService.getByOrderID(id).getTaxiDriverEntity();
        taxiDriverEntityDTO.setStatus(0);
        taxiDriverService.editDriver(taxiDriverEntityDTO, taxiOrderService.getByOrderID(id).getTaxiDriverEntity().getId());
        return "Order is closed";
    }


}




