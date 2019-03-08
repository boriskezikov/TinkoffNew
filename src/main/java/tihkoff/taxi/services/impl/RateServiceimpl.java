package tihkoff.taxi.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tihkoff.taxi.dto.RateEntityDTO;
import tihkoff.taxi.mapper.RateEntityMapper;
import tihkoff.taxi.repository.RateRepository;
import tihkoff.taxi.services.RateService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RateServiceimpl implements RateService {
    private final RateRepository rateRepository;
    private final RateEntityMapper rateEntityMapper;

    @Override
    public RateEntityDTO addRate(RateEntityDTO rateEntityDTO) {
       return rateEntityMapper
               .rateEntityMAp(rateRepository
                       .save(rateEntityMapper
                               .rateEntityDTOmap(rateEntityDTO)));

    }

    @Override
    public List<RateEntityDTO> getAll() {
        return rateEntityMapper.conveter(rateRepository.findAll());
    }

    @Override
    public RateEntityDTO getRateById(Long rateID) {
        return rateRepository
                .findById(rateID)
                .map(rateEntityMapper::rateEntityMAp)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(Long rateID) {
        rateRepository.deleteById(rateID);

    }

    @Override
    public void deleteAll() {
        rateRepository.deleteAll();

    }

    @Override
    public RateEntityDTO editRate(RateEntityDTO rateEntityDTO, Long rateID) {
        rateEntityDTO.setId(rateID);
        return rateEntityMapper.
                rateEntityMAp(rateRepository.
                        save(rateEntityMapper.
                                updateRate(rateEntityDTO,
                                        rateEntityMapper.rateEntityDTOmap(getRateById(rateID)))));
    }
}
