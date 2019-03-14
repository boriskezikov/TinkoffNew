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
    public TaxiDriverEntityDTO addDriver(TaxiDriverEntityDTO taxiDriverEntityDTO) {
         TaxiDriverEntity taxiDriverEntity = taxiDriverEntityRepository
                .save(taxiDriverEntityMapper
                        .taxiDriverDTOmap(taxiDriverEntityDTO));
         return taxiDriverEntityMapper.taxiDriverMap(taxiDriverEntityRepository
                 .findById(taxiDriverEntity.getId())
                 .orElseThrow(NullPointerException::new));


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
    public TaxiDriverEntityDTO editDriver(TaxiDriverEntityDTO taxiDriverEntityDTO, Long driverId) {
        TaxiDriverEntity taxiDriverEntity = taxiDriverEntityMapper.taxiDriverDTOmap(getById(driverId));
        taxiDriverEntityDTO.setId(driverId);
        return taxiDriverEntityMapper
                .taxiDriverMap(taxiDriverEntityRepository
                        .save(taxiDriverEntityMapper
                                .updateTaxiDriver(taxiDriverEntityDTO, taxiDriverEntity)));
    }
}
