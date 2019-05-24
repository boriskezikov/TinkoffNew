package tihkoff.taxi.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import tihkoff.taxi.API.PrimaryData;
import tihkoff.taxi.domain.ClientEntity;
import tihkoff.taxi.dto.ClientEntityDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {
    ClientEntityDTO clientEntityMap(ClientEntity clientEntity);

    List<ClientEntityDTO> conveter(List<ClientEntity> clientEntities);

    ClientEntity clientEntityDTOmap(ClientEntityDTO clientEntityDTO);

    ClientEntity updateClient(ClientEntityDTO clientEntityDTO, @MappingTarget ClientEntity clientEntity);

    @Mappings
            ({
                    @Mapping(target = "name", source = "primaryData.name"),
                    @Mapping(target = "phoneNumber", source = "primaryData.phoneNumber"),
                    @Mapping(target = "status", source = "primaryData.status")
            })
    ClientEntityDTO ApiDtoToClientDto(PrimaryData primaryData);
}
