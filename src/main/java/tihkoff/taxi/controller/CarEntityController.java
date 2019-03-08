package tihkoff.taxi.controller;



import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.services.CarService;


import javax.validation.Valid;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarEntityController {
    private final CarService carService;

    @GetMapping("{car_id}")
    public CarEntityDTO getCar(@PathVariable("car_id") Long car_id)
    {
       return carService.getByCarId(car_id);
    }


    @GetMapping
    public List<CarEntityDTO>getAll()

    {
        return carService.getAll();
    }

    @PostMapping
    public CarEntityDTO addCar(@RequestBody @Valid CarEntityDTO carEntityDTO)
    {
        return carService.addCar(carEntityDTO);
    }

    @PutMapping("{id}")
    public CarEntityDTO editCar(@RequestBody @Valid CarEntityDTO carEntityDTO, @PathVariable("id") long carId)

    {
        return carService.editCar(carEntityDTO, carId);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable("id") long carId)
    {
        carService.deleteById(carId);

    }

}













