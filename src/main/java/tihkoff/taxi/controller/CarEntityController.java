package tihkoff.taxi.controller;


import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.Message;
import org.springframework.web.bind.annotation.*;
import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.mapper.CarEntityMapper;
import tihkoff.taxi.services.CarService;

import javax.validation.Valid;
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
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public void addCar(@RequestParam(value = "manufacturerId") String manufacturerID,
                                @RequestParam(value = "techCondition") int techCondition,
                                @RequestParam(value = "category") int category )  throws IOException {
        CarEntityDTO carEntityDTO = new CarEntityDTO();
        carEntityDTO.setManufacturerId(manufacturerID);
        carEntityDTO.setCategory(category);
        carEntityDTO.setTechCondition(techCondition);
        carService.addCar(carEntityMapper.carEntityDTOmap(carEntityDTO));
                /** Add Header response and argument validation**/
    }









}
