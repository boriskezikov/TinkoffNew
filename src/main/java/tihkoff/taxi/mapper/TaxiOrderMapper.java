package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import tihkoff.taxi.domain.TaxiOrderEntity;
import tihkoff.taxi.dto.TaxiOrderDTO;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TaxiOrderMapper {
    TaxiOrderDTO taxiOrderEntityMap (TaxiOrderEntity taxiOrderEntity);
    List<TaxiOrderDTO> conveter(List<TaxiOrderEntity> clientEntities);
    TaxiOrderEntity taxiOrderEntityDTOmap(TaxiOrderDTO clientEntityDTO);
    TaxiOrderEntity updateOrder(TaxiOrderDTO taxiOrderDTO, @MappingTarget TaxiOrderEntity taxiOrderEntity);
}
