package tihkoff.taxi.mapper;

import org.mapstruct.Mapper;
import tihkoff.taxi.domain.ClientEntity;
import tihkoff.taxi.dto.ClientEntityDTO;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {
    ClientEntityDTO clientEntityMap(ClientEntity clientEntity);
}
