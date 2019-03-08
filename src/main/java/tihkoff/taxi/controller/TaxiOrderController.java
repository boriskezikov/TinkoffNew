package tihkoff.taxi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tihkoff.taxi.dto.TaxiOrderDTO;
import tihkoff.taxi.services.TaxiOrderService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/orders")
@RequiredArgsConstructor
@RestController
public class TaxiOrderController {
    private final TaxiOrderService taxiOrderService;


    @GetMapping("{id}")
    public TaxiOrderDTO getOrderById(@PathVariable("id") Long orderId) {
        return taxiOrderService.getByOrderID(orderId);
    }

    @GetMapping
    public List<TaxiOrderDTO> getAll() {
        return taxiOrderService.getAll();
    }

    @DeleteMapping("{id}")

    public void deleteById(@PathVariable("id") Long orderID) {
        taxiOrderService.deleteOrderByID(orderID);
    }

    @PutMapping("{id}")
    public TaxiOrderDTO editById(@PathVariable("id") @RequestBody @Valid TaxiOrderDTO taxiOrderDTO, Long id) {
        return taxiOrderService.editOrder(taxiOrderDTO, id);
    }

    @PostMapping
    public TaxiOrderDTO addOrder(@RequestBody @Valid TaxiOrderDTO taxiOrderDTO) {

        return taxiOrderService.createOrder(taxiOrderDTO);
    }
}
