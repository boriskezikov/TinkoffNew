package tihkoff.taxi.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tihkoff.taxi.domain.ClientEntity;
import tihkoff.taxi.dto.ClientEntityDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {
    ClientEntityDTO clientEntityMap(ClientEntity clientEntity);
    List<ClientEntityDTO> conveter(List<ClientEntity> clientEntities);
    ClientEntity clientEntityDTOmap(ClientEntityDTO clientEntityDTO);
    ClientEntity updateClient(ClientEntityDTO clientEntityDTO, @MappingTarget  ClientEntity clientEntity);

}
