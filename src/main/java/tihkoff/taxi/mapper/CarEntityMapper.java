package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarEntityMapper {
    CarEntityDTO carEntityMap(CarEntity carEntity);
    List<CarEntityDTO> conveter(List<CarEntity> carEntities);
}
