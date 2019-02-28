package tihkoff.taxi.services;

import tihkoff.taxi.dto.TaxiOrderDTO;

import java.util.List;

public interface TaxiOrderService {
    TaxiOrderDTO getByOrderID(Long orderID);
    List<TaxiOrderDTO> getByDriverId(Integer driverId);
    List<TaxiOrderDTO> getAll();
    List<TaxiOrderDTO> getByClientPhone(String phone);
    List<TaxiOrderDTO> getByTariffID(Integer tariffID);
    List<TaxiOrderDTO> getByOrderStatus(Integer orderStatus);
    TaxiOrderDTO createOrder(TaxiOrderDTO taxiOrderDTO);
    TaxiOrderDTO editOrder(TaxiOrderDTO taxiOrderDTO, Long orderID);
    TaxiOrderDTO editStatus(TaxiOrderDTO taxiOrderDTO, Long orderID);
    void deleteOrderByID(Long orderID);

}
