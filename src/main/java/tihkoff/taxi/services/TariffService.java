package tihkoff.taxi.services;


import tihkoff.taxi.dto.TariffEntityDTO;


import java.util.List;

public interface TariffService {
    List<TariffEntityDTO> getAll();
    TariffEntityDTO getById(Integer tariffID);
    void deleteById(Integer tariffID);
    void deleteAll();
    List<TariffEntityDTO>getByPriceLess(Integer price);
    List<TariffEntityDTO>getByPriceGreater(Integer price);
    TariffEntityDTO addTariff(TariffEntityDTO tariffEntityDTO);
    TariffEntityDTO editTariff (TariffEntityDTO tariffEntityDTO, Integer tariffID);


}
