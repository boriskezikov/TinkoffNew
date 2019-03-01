package tihkoff.taxi.services;

import tihkoff.taxi.domain.TaxiDriverEntity;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;

import java.util.List;

public interface TaxiDriverService {
    TaxiDriverEntityDTO getById(Long driverID);
    List<TaxiDriverEntityDTO> getAll();
    void addDriver(TaxiDriverEntityDTO taxiDriverEntityDTO);
    TaxiDriverEntityDTO getByLicence(String licenceNum);
    TaxiDriverEntityDTO getByPassport(String passportNum);
    TaxiDriverEntityDTO getByCarId(Long carID);
    void deleteAll();
    void deleteById(Long id);
    void deleteByPassport(String passport);
    void deleteByLicense(String licenceNumber);
    TaxiDriverEntityDTO editDriver(TaxiDriverEntityDTO taxiDriverEntityDTO, Long driverID);


}
