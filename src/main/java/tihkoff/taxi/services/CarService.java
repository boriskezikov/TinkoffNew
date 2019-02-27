package tihkoff.taxi.services;

import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;

import java.util.List;

public interface CarService {
    CarEntity addCar(CarEntity carEntity);
    List<CarEntityDTO> getAll();
    void DeleteById(Long id);
    void DeleteAll();
    CarEntity EditCar(CarEntity carEntity);
    List<CarEntity> getByModel(String model);
    CarEntity getCarByConditionGreaterThan(int techCondition);
    CarEntityDTO getByCarId(long id);

}
