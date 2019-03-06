package tihkoff.taxi.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tihkoff.taxi.domain.TariffEntity;
import tihkoff.taxi.dto.TariffEntityDTO;
import tihkoff.taxi.mapper.TariffEntityMapper;
import tihkoff.taxi.repository.TariffRepository;
import tihkoff.taxi.services.TariffService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TariffServiceimpl implements TariffService {
    private final TariffRepository tariffRepository;
    private final TariffEntityMapper tariffEntityMapper;
    @Override
    public List<TariffEntityDTO> getAll() {
        return tariffEntityMapper.conveter(tariffRepository.findAll());
    }

    @Override
    public TariffEntityDTO getById(Integer tariffID) {
        return tariffRepository.findById(tariffID)
                .map(tariffEntityMapper::tariffEntityMap)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(Integer tariffID) {
        tariffRepository.deleteById(tariffID);

    }

    @Override
    public void deleteAll() {
        tariffRepository.deleteAll();

    }

    @Override
    public List<TariffEntityDTO> getByPriceLess(Integer price) {
        return tariffEntityMapper.conveter(tariffRepository.getByPriceLessThan(price));
    }

    @Override
    public List<TariffEntityDTO> getByPriceGreater(Integer price) {
        return tariffEntityMapper.conveter(tariffRepository.getByPriceGreaterThan(price));
    }

    @Override
    public TariffEntityDTO addTariff(TariffEntityDTO tariffEntityDTO) {
        return tariffEntityMapper.tariffEntityMap(tariffRepository.save(tariffEntityMapper.tariffEntityDTOmap(tariffEntityDTO)));

    }

    @Override
    public TariffEntityDTO editTariff(TariffEntityDTO tariffEntityDTO, Integer tariffID) {

        TariffEntity tariffEntity = tariffEntityMapper.tariffEntityDTOmap(getById(tariffID));
        return tariffEntityMapper.tariffEntityMap(tariffRepository.save(tariffEntityMapper.updateTariff(tariffEntityDTO, tariffEntity)));

    }
}
