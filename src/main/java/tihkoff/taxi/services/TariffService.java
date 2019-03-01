package tihkoff.taxi.services;

import tihkoff.taxi.domain.TariffEntity;
import tihkoff.taxi.dto.TariffEntityDTO;
import tihkoff.taxi.dto.TaxiDriverEntityDTO;

import java.util.List;

public interface TariffService {
    List<TariffEntityDTO> getAll();
    TariffEntityDTO getById(Integer tariffID);
    void deleteById(Integer tariffID);
    void deleteAll();
    List<TariffEntityDTO>getByPriceLess(Integer price);
    List<TariffEntityDTO>getByPriceGreater(Integer price);
    void addTariff(TariffEntityDTO tariffEntityDTO);
    TariffEntityDTO editTariff (TaxiDriverEntityDTO taxiDriverEntityDTO, Integer tariffID);


}
