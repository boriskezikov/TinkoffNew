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

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class API {

    private final TaxiOrderService taxiOrderService;
    private final ClientRepository clientRepository;
    private final ClientEntityMapper clientEntityMapper;
    private final OrderComputing orderComputing;
    private final ClientService clientService;
    private final TaxiDriverService taxiDriverService;

    @PostMapping
    public TaxiOrderDTO startSetOrder(@RequestBody @Valid PrimaryData primaryData) {


        List<ClientEntityDTO> clients = clientService.getAll();
        ClientEntityDTO clientEntityDTO = clientEntityMapper.ApiDtoToClientDto(primaryData);

        if (!clients.contains(clientEntityDTO)) {
            clientRepository.save(clientEntityMapper.clientEntityDTOmap(clientEntityDTO));

        }
        TaxiDriverEntityDTO taxiDriverEntityDTO = orderComputing.searchDriver();

        TaxiOrderDTO taxiOrderDTO = new TaxiOrderDTO(
                taxiDriverEntityDTO,
                clientEntityDTO,
                primaryData.location,
                primaryData.destination,
                1,
                orderComputing.searchTariff(),
                new RateEntityDTO()
        );


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




