package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import tihkoff.taxi.domain.RateEntity;
import tihkoff.taxi.dto.RateEntityDTO;


@Mapper(componentModel = "spring")
public interface RateEntityMapper {
    RateEntityDTO rateEntityMAp (RateEntity rateEntity);
}
