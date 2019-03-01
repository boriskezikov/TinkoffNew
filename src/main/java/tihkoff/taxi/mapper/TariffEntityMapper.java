package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tihkoff.taxi.domain.TariffEntity;
import tihkoff.taxi.dto.TariffEntityDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TariffEntityMapper {
    TariffEntityDTO tariffEntityMap(TariffEntity tariffEntities);
    List<TariffEntityDTO> conveter(List<TariffEntity> tariffEntities);
    TariffEntity tariffEntityDTOmap(TariffEntityDTO tariffEntityDTO);
    TariffEntity updateaTariff(TariffEntityDTO tariffEntityDTO, @MappingTarget TariffEntity tariffEntity);
}
