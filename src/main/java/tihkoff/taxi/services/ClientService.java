package tihkoff.taxi.services;


import tihkoff.taxi.dto.ClientEntityDTO;

import java.util.List;

public interface ClientService {
    void addClient(ClientEntityDTO clientEntityDTO);
    List<ClientEntityDTO> getAll();
    void DeleteByPhone(String phone);
    void DeleteAll();
    ClientEntityDTO EditClient(ClientEntityDTO clientEntityDTO, String phone);
    ClientEntityDTO getByPhone(String model);
    boolean changeStatus(ClientEntityDTO clientEntityDTO);
}
