package tihkoff.taxi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.services.CarService;

import java.util.List;
import java.util.concurrent.RecursiveAction;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarEntityController {
    private final CarService carService;

    @GetMapping("{id}")
    public CarEntityDTO getCar(@PathVariable("id") long carId){
        return carService.getByCarId(carId);

    }
//    @GetMapping
//    public List<CarEntityDTO>getByCondition(int condition)throws StackOverflowError {
//        return getByCondition(condition);
//    }
    @GetMapping
    public List<CarEntityDTO>getAll(){
        return carService.getAll();

    }








}
