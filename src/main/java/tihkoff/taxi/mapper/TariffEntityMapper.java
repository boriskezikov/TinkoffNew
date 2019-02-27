package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import tihkoff.taxi.domain.TariffEntity;
import tihkoff.taxi.dto.TariffEntityDTO;

@Mapper(componentModel = "spring")
public interface TariffEntityMapper {
    TariffEntityDTO tariffMap(TariffEntity tariffEntity);
}
