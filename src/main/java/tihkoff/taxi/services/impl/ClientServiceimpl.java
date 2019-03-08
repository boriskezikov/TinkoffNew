package tihkoff.taxi.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tihkoff.taxi.domain.ClientEntity;
import tihkoff.taxi.dto.ClientEntityDTO;
import tihkoff.taxi.mapper.ClientEntityMapper;
import tihkoff.taxi.repository.ClientRepository;
import tihkoff.taxi.services.ClientService;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceimpl implements ClientService {
    public final ClientRepository clientRepository;
    public final ClientEntityMapper clientEntityMapper;

    @Override
    public ClientEntityDTO addClient(ClientEntityDTO clientEntityDTO) {
        return clientEntityMapper
                .clientEntityMap(clientRepository
                        .save(clientEntityMapper
                                .clientEntityDTOmap(clientEntityDTO)));
    }

    @Override
    public List<ClientEntityDTO> getAll() {
        return clientEntityMapper.conveter(clientRepository.findAll());
    }

    @Override
    public void deleteByPhone(String phone) {

        this.clientRepository.deleteByPhoneNumber(phone);
    }

    @Override
    public void deleteAll() {
        clientRepository.deleteAll();
    }

    @Override
    public ClientEntityDTO editClient(ClientEntityDTO clientEntityDTO, String phone) {
      ClientEntity clientEntity = clientEntityMapper.clientEntityDTOmap(getByPhone(phone));
      clientEntityDTO.setPhoneNumber(phone);
      return clientEntityMapper.
              clientEntityMap(clientRepository.
                      save(clientEntityMapper.
                              updateClient(clientEntityDTO,clientEntity)));
    }

    @Override
    public ClientEntityDTO getByPhone(String phone) {
        return clientRepository
                .findByPhoneNumber(phone)
                .map(clientEntityMapper::clientEntityMap)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public boolean changeStatus(ClientEntityDTO clientEntityDTO) {
        return false;
    }



}