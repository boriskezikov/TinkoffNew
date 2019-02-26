package tihkoff.taxi.services.impl;

import org.springframework.stereotype.Service;
import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.repository.CarRepository;
import tihkoff.taxi.services.CarService;


import java.util.List;


@Service
public class CarServiceimpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceimpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @Override
    public CarEntity addCar(CarEntity carEntity){
        return this.carRepository.saveAndFlush(carEntity);
    }

    @Override
    public List<CarEntity> getAll(){
        return this.carRepository.findAll();
    }

    @Override
    public void DeleteById(Long id){
         this.carRepository.deleteById(id);

    }

    @Override
    public void DeleteAll(){
        this.carRepository.deleteAll();
    }

    @Override
    public CarEntity EditCar (CarEntity carEntity){
        if(this.carRepository.findById(carEntity.getCarId()).isPresent()){
            this.carRepository.deleteById(carEntity.getCarId());
        }
        return this.carRepository.saveAndFlush(carEntity);
    }

    @Override
    public List<CarEntity> getByModel(String model){
        return this.carRepository.findAllByModelInfo(model);
    }

    @Override
    public CarEntity getCarByConditionGreaterThan(int techCondition){
        return this.carRepository.findDistinctByTechConditionIsGreaterThan(techCondition);
    }


}
