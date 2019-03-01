package tihkoff.taxi.controller;



import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.mapper.CarEntityMapper;
import tihkoff.taxi.services.CarService;


import javax.validation.Valid;

import java.util.List;




@RestController
@RequiredArgsConstructor
@RequestMapping("/CAR_ENTITY")
public class CarEntityController {
    private final CarService carService;
    private final CarEntityMapper carEntityMapper;



    @GetMapping("{car_id}")
    public CarEntityDTO getCar(@PathVariable("car_id") long car_id)throws NumberFormatException
    {
       return carService.getByCarId(car_id);
    }

    @GetMapping
    public List<CarEntityDTO>getAll()

    {
        return carService.getAll();
    }

    @PostMapping("/poster")
    public void addCar(@RequestBody @Valid CarEntityDTO carEntityDTO) throws java.lang.IllegalStateException

    {
        carService.addCar(carEntityDTO);
    }

    @PutMapping("/edit/{id}")
    public CarEntityDTO editCar(@RequestBody @Valid CarEntityDTO carEntityDTO, @PathVariable("id") long carId)
    {
        return carService.editCar(carEntityDTO, carId);

    }
    @DeleteMapping("delete/{id}")
    public void deleteCar(@PathVariable("id") long carId)
    {
        carService.deleteById(carId);

    }

}













