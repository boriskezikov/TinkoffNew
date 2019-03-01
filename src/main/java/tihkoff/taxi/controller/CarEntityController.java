package tihkoff.taxi.controller;



import lombok.RequiredArgsConstructor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.mapper.CarEntityMapper;
import tihkoff.taxi.services.CarService;


import java.io.IOException;
import java.util.List;




@RestController
@RequiredArgsConstructor
@RequestMapping("/CAR_ENTITY")
public class CarEntityController {
    private final CarService carService;
    private final CarEntityMapper carEntityMapper;



    @GetMapping("{car_id}")
    public CarEntityDTO getCar(@PathVariable("car_id") long car_id)throws NumberFormatException{
       return carService.getByCarId(car_id);

    }
    @GetMapping
    private List<CarEntityDTO>getAll(){
        return carService.getAll();
    }
    @PostMapping("{post}")
    public CarEntityDTO addCar(@PathVariable("post")
                                   @RequestParam(value = "techCondition") int techCondition,
                                               @RequestParam(value = "category") int category,
                                               @RequestParam(value = "manufacturerid") long maId,
                                               @RequestParam(value = "carId") long id,
                                               @RequestParam(value = "model") String Model)  throws IOException {
        CarEntityDTO carEntityDTO = new CarEntityDTO();
        carEntityDTO.setCategory(category);
        carEntityDTO.setCarId(id);
        carEntityDTO.setManufacturerId(maId);
        carEntityDTO.setModelInfo(Model);
        carEntityDTO.setTechCondition(techCondition);
        carService.addCar(carEntityDTO);
                /** Add Header response and argument validation**/
                return carEntityDTO;
    }








}
