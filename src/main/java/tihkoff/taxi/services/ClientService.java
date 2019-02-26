package tihkoff.taxi.services;

import tihkoff.taxi.domain.ClientEntity;

import java.util.List;

public interface ClientService {
    ClientEntity addClient(ClientEntity clientEntity);
    List<ClientEntity> getAll();
    void Delete(ClientEntity clientEntity);
    void DeleteAll();
    ClientEntity EditCar(ClientEntity clientEntity);
    List<ClientEntity> getByPhone(String model);
    boolean changeStatus(ClientEntity clientEntity);
}
