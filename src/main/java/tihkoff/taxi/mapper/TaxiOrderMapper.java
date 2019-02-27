package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import tihkoff.taxi.domain.TaxiOrderEntity;
import tihkoff.taxi.dto.TaxiOrderDTO;

@Mapper(componentModel = "spring")
public interface TaxiOrderMapper {
    TaxiOrderDTO taxiOrderMAp (TaxiOrderEntity taxiOrderEntity);
}
