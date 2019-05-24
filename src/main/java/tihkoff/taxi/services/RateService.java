package tihkoff.taxi.services;

import tihkoff.taxi.dto.RateEntityDTO;

import java.util.List;

public interface RateService {
    RateEntityDTO addRate(RateEntityDTO rateEntityDTO);
    List<RateEntityDTO> getAll();
    RateEntityDTO getRateById(Long rateID);
    void deleteById(Long rageID);
    void deleteAll();
    RateEntityDTO editRate(RateEntityDTO rateEntityDTO ,Long rateID);

}
