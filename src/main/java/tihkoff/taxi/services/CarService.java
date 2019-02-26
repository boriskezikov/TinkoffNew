package tihkoff.taxi.services;

import tihkoff.taxi.domain.CarEntity;

import java.util.List;

public interface CarService {
    CarEntity addCar(CarEntity carEntity);
    List<CarEntity> getAll();
    void DeleteById(Long id);
    void DeleteAll();
    CarEntity EditCar(CarEntity carEntity);
    List<CarEntity> getByModel(String model);
    CarEntity getCarByConditionGreaterThan(int techCondition);

}
