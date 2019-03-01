package tihkoff.taxi.services;

import tihkoff.taxi.dto.CarEntityDTO;

import java.util.List;

public interface CarService {
    void addCar(CarEntityDTO DTO);
    List<CarEntityDTO> getAll();
    void DeleteById(Long id);
    void DeleteAll();
    CarEntityDTO EditCar(CarEntityDTO carEntityDTO, Long carId);
    List<CarEntityDTO>  getCarEntitiesByCategory (Integer category);
    CarEntityDTO getByCarId(Long id);

}
