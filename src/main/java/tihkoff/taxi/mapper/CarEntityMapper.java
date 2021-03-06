package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarEntityMapper {
    CarEntityDTO carEntityMap(CarEntity carEntity);
    List<CarEntityDTO> conveter(List<CarEntity> carEntities);
    CarEntity carEntityDTOmap(CarEntityDTO carEntityDTO);
    CarEntity updateCar(CarEntityDTO carEntityDTO, @MappingTarget CarEntity carEntity);


}
