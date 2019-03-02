package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tihkoff.taxi.domain.RateEntity;
import tihkoff.taxi.dto.RateEntityDTO;

import java.util.List;


@Mapper(componentModel = "spring")
public interface RateEntityMapper {
    RateEntityDTO rateEntityMAp (RateEntity rateEntity);
    List<RateEntityDTO> conveter(List<RateEntity> rateEntities);
    RateEntity rateEntityDTOmap(RateEntityDTO rateEntityDTO);
    RateEntity updateRate(RateEntityDTO clientEntityDTO, @MappingTarget RateEntity rateEntity);

}
