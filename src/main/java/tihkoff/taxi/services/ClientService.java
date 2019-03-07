package tihkoff.taxi.services;


import tihkoff.taxi.dto.ClientEntityDTO;

import java.util.List;

public interface ClientService {
    ClientEntityDTO addClient(ClientEntityDTO clientEntityDTO);
    List<ClientEntityDTO> getAll();
    void deleteByPhone(String phone);
    void deleteAll();
    ClientEntityDTO editClient(ClientEntityDTO clientEntityDTO, String phone);
    ClientEntityDTO getByPhone(String model);
    boolean changeStatus(ClientEntityDTO clientEntityDTO);
}
