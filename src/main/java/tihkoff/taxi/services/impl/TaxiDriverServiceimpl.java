package tihkoff.taxi.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import tihkoff.taxi.domain.TaxiDriverEntity;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;
import tihkoff.taxi.mapper.TaxiDriverEntityMapper;
import tihkoff.taxi.repository.TaxiDriverEntityRepository;
import tihkoff.taxi.services.TaxiDriverService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaxiDriverServiceimpl implements TaxiDriverService {
    private final TaxiDriverEntityRepository taxiDriverEntityRepository;
    private final TaxiDriverEntityMapper taxiDriverEntityMapper;

    @Override
    public TaxiDriverEntityDTO getById(Long driverID) {
        return taxiDriverEntityRepository.findById(driverID)
                .map(taxiDriverEntityMapper::taxiDriverMap)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TaxiDriverEntityDTO> getAll() {
        return taxiDriverEntityMapper
                .conveter(taxiDriverEntityRepository
                        .findAll());
    }

    @Override
    public void addDriver(TaxiDriverEntityDTO taxiDriverEntityDTO) {
        taxiDriverEntityRepository
                .save(taxiDriverEntityMapper
                        .taxiDriverDTOmap(taxiDriverEntityDTO));

    }

    @Override
    public TaxiDriverEntityDTO getByLicence(String licenceNum) {
        return taxiDriverEntityRepository.getByLicenseNumber(licenceNum)
                .map(taxiDriverEntityMapper::taxiDriverMap)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public TaxiDriverEntityDTO getByPassport(String passportNum) {
        return taxiDriverEntityRepository
                .getByPassport(passportNum)
                .map(taxiDriverEntityMapper::taxiDriverMap)
                .orElseThrow(EntityNotFoundException::new);
    }



    @Override
    public void deleteAll() {
        taxiDriverEntityRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {
        taxiDriverEntityRepository.deleteById(id);

    }

    @Override
    public void deleteByPassport(String passport) {
        taxiDriverEntityRepository.deleteByPassport(passport);

    }

    @Override
    public void deleteByLicense(String licenceNumber) {
        taxiDriverEntityRepository.deleteByLicenseNumber(licenceNumber);

    }

    @Override
    public TaxiDriverEntityDTO editDriver(TaxiDriverEntityDTO taxiDriverEntityDTO, Long driverID) {
        TaxiDriverEntity taxiDriverEntity = taxiDriverEntityMapper.taxiDriverDTOmap(getById(driverID));
        taxiDriverEntityDTO.setDriverID(driverID);
        return taxiDriverEntityMapper
                .taxiDriverMap(taxiDriverEntityRepository
                        .save(taxiDriverEntityMapper.updateTaxiDriver(taxiDriverEntityDTO,taxiDriverEntity)));
    }
}
