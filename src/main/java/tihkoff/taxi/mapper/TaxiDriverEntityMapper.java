package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import tihkoff.taxi.domain.TaxiDriverEntity;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;

@Mapper(componentModel = "spring")
public interface TaxiDriverEntityMapper {
    TaxiDriverEntityDTO taxiDriverMap(TaxiDriverEntity taxiDriverEntity);
}
