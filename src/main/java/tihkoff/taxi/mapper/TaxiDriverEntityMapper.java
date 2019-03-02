package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tihkoff.taxi.domain.TaxiDriverEntity;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaxiDriverEntityMapper {
    TaxiDriverEntityDTO taxiDriverMap(TaxiDriverEntity taxiDriverEntity);
    List<TaxiDriverEntityDTO> conveter(List<TaxiDriverEntity> taxiDriverEntities);
    TaxiDriverEntity taxiDriverDTOmap(TaxiDriverEntityDTO taxiDriverDTO);
    TaxiDriverEntity updateTaxiDriver(TaxiDriverEntityDTO taxiDriverDTO, @MappingTarget TaxiDriverEntity taxiDriverEntity);
}
