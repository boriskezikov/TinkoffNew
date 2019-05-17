package tihkoff.taxi.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;
import tihkoff.taxi.mapper.CarEntityMapper;
import tihkoff.taxi.repository.CarRepository;
import tihkoff.taxi.services.CarService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceimpl implements CarService {

    private final CarRepository carRepository;
    private final CarEntityMapper carEntityMapper;

    @Override
    public CarEntityDTO getByCarId(Long id) {
        return carRepository.findById(id).map(carEntityMapper::carEntityMap).orElseThrow(EntityNotFoundException::new);

    }

    @Override
    public CarEntityDTO addCar(CarEntityDTO carEntityDTO) {
        return carEntityMapper.carEntityMap(carRepository.save(carEntityMapper.carEntityDTOmap(carEntityDTO)));
    }

    @Override
    public List<CarEntityDTO> getAll() {
        return carEntityMapper.conveter(carRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        this.carRepository.deleteById(id);

    }

    @Override
    public void deleteAll() {
        this.carRepository.deleteAll();
    }

    @Override
    public  CarEntityDTO editCar(CarEntityDTO carEntityDTO, Long carId) {

        CarEntity carEntity = carEntityMapper.carEntityDTOmap(getByCarId(carId));
        carEntityDTO.setId(carId);
        return carEntityMapper.
                carEntityMap(carRepository.
                        save(carEntityMapper.
                                updateCar(carEntityDTO, carEntity)));
    }


    @Override
    public List<CarEntityDTO> getCarEntitiesByCategory(Integer category) {
        return carEntityMapper
                .conveter(carRepository
                        .getCarEntitiesByCategory(category));

    }


}
