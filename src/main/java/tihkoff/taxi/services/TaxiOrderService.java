package tihkoff.taxi.services;

import tihkoff.taxi.dto.TaxiOrderDTO;

import java.util.List;

public interface TaxiOrderService {
    TaxiOrderDTO getByOrderID(Long orderID);
    List<TaxiOrderDTO> getByDriverId(Integer driverId);
    List<TaxiOrderDTO> getByClientPhone(String phone);
    List<TaxiOrderDTO> getByTariffID(Integer tariffID);
    List<TaxiOrderDTO> getByOrderStatus(Integer orderStatus);



}
