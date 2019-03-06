package tihkoff.taxi.services;

import tihkoff.taxi.dto.CarEntityDTO;

import java.util.List;

public interface CarService {
    CarEntityDTO addCar(CarEntityDTO DTO);
    List<CarEntityDTO> getAll();
    void deleteById(Long id);
    void deleteAll();
    CarEntityDTO editCar(CarEntityDTO carEntityDTO, Long carId);
    List<CarEntityDTO>  getCarEntitiesByCategory (Integer category);
    CarEntityDTO getByCarId(Long id);

}
