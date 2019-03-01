package tihkoff.taxi.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.mapper.CarEntityMapper;
import tihkoff.taxi.repository.CarRepository;
import tihkoff.taxi.services.CarService;


import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceimpl implements CarService {

    private final CarRepository carRepository;
    private final CarEntityMapper carEntityMapper;

    //public CarServiceimpl(CarRepository carRepository) {this.carRepository = carRepository; }
    @Override
    public void addCar(CarEntityDTO carEntityDTO) {
        carRepository.saveAndFlush(carEntityMapper.carEntityDTOmap(carEntityDTO));
    }

    @Override
    public List<CarEntityDTO> getAll() {
        List<CarEntity> carEntities = carRepository.findAll();
        return carEntityMapper.conveter(carEntities);

    }

    @Override
    public void DeleteById(Long id) {
        this.carRepository.deleteById(id);

    }

    @Override
    public void DeleteAll() {

        this.carRepository.deleteAll();
    }

    @Override
    public CarEntityDTO EditCar(CarEntityDTO carEntityDTO) {
        if (this.carRepository.findById(carEntityDTO.getCarId()).isPresent()) {
            this.carRepository.deleteById(carEntityDTO.getCarId());
        }
        return null;//carRepository.save(carEntityMapper.carEntityDTOmap(carEntityDTO));
    }

    @Override
    public   List<CarEntityDTO> getCarEntitiesByCategory(int category){
        return carEntityMapper.conveter(carRepository.getCarEntitiesByCategory(category));

    }

    @Override
    public CarEntityDTO getByCarId ( long id)
    {
        return carEntityMapper.carEntityMap(carRepository.getByCarId(id));

    }


}
