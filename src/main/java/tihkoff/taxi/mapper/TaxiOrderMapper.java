package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tihkoff.taxi.domain.TaxiOrderEntity;
import tihkoff.taxi.dto.TaxiOrderDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaxiOrderMapper {
    TaxiOrderDTO taxiOrderEntityMap (TaxiOrderEntity taxiOrderEntity);
    List<TaxiOrderDTO> conveter(List<TaxiOrderEntity> clientEntities);
    TaxiOrderEntity taxiOrderEntityDTOmap(TaxiOrderDTO clientEntityDTO);
    TaxiOrderEntity updateClient(TaxiOrderDTO clientEntityDTO, @MappingTarget TaxiOrderEntity taxiOrderEntity);
}
