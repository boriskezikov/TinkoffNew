package tihkoff.taxi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.services.CarService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("car")
public class CarEntityController {
    private final CarService carService;


    @GetMapping("{car_id}")
    public CarEntityDTO getCar(@PathVariable("car_id") long car_id)throws NumberFormatException{
       return carService.getByCarId(car_id);

    }

    @GetMapping
    public List<CarEntityDTO>getAll(){
        return carService.getAll();

    }









}
