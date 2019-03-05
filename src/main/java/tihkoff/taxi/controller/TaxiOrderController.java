package tihkoff.taxi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tihkoff.taxi.domain.TaxiOrderEntity;
import tihkoff.taxi.dto.TaxiOrderDTO;
import tihkoff.taxi.services.TaxiOrderService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/order-entity")
@RequiredArgsConstructor
@RestController
public class TaxiOrderController {
    private final TaxiOrderService taxiOrderService;


    @GetMapping("/get/{id}")
    public TaxiOrderDTO getOrderById(@PathVariable("id") Long orderID){
        return taxiOrderService.getByOrderID(orderID);
    }

    @GetMapping
    public List<TaxiOrderDTO> getAll(){
        return taxiOrderService.getAll();
    }

    @DeleteMapping("/del/{id}")
    public void deleteById(@PathVariable("id") Long orderID){
        taxiOrderService.deleteOrderByID(orderID);
    }


    @PutMapping("/edit/{id}")
    public TaxiOrderDTO editByID(@PathVariable("id") @RequestBody @Valid TaxiOrderDTO taxiOrderDTO, Long id){
        return taxiOrderService.editOrder(taxiOrderDTO,id);
    }

    @PostMapping("/post")
    public void addOrder(@RequestBody @Valid TaxiOrderDTO taxiOrderDTO){
        taxiOrderService.createOrder(taxiOrderDTO);
    }
}
