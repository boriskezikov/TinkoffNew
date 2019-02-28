package tihkoff.taxi.services;

import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;

import java.util.List;

public interface CarService {
    CarEntity addCar(CarEntity carEntity);
    List<CarEntityDTO> getAll();
    void DeleteById(Long id);
    void DeleteAll();
    CarEntityDTO EditCar(CarEntity carEntity);
    List<CarEntityDTO>  getCarEntitiesByCategory (int category);
    //CarEntityDTO getCarByConditionGreaterThan(int techCondition);
    CarEntityDTO getByCarId(long id);

}
