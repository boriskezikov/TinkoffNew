package tihkoff.taxi.services;

import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;

import java.util.List;

public interface CarService {
    void addCar(CarEntityDTO DTO);
    List<CarEntityDTO> getAll();
    void DeleteById(Long id);
    void DeleteAll();
    CarEntityDTO EditCar(CarEntityDTO carEntityDTO);
    List<CarEntityDTO>  getCarEntitiesByCategory (int category);
    //CarEntityDTO getCarByConditionGreaterThan(int techCondition);
    CarEntityDTO getByCarId(long id);

}
