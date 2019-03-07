package tihkoff.taxi.services;

import ch.qos.logback.core.net.server.Client;
import tihkoff.taxi.domain.ClientEntity;
import tihkoff.taxi.domain.TariffEntity;
import tihkoff.taxi.domain.TaxiDriverEntity;
import tihkoff.taxi.dto.TariffEntityDTO;
import tihkoff.taxi.dto.TaxiOrderDTO;

import java.util.List;

public interface TaxiOrderService {
    TaxiOrderDTO getByOrderID(Long orderID);
    List<TaxiOrderDTO> getByDriver(TaxiDriverEntity taxiDriverEntity);
    List<TaxiOrderDTO> getAll();
    List<TaxiOrderDTO> getByClientEntity(ClientEntity clientEntity);
    List<TaxiOrderDTO> getByTariff(TariffEntity tariffEntity);
    List<TaxiOrderDTO> getByOrderStatus(Integer orderStatus);
    TaxiOrderDTO createOrder(TaxiOrderDTO taxiOrderDTO);
    TaxiOrderDTO editOrder(TaxiOrderDTO taxiOrderDTO, Long orderID);
    TaxiOrderDTO editStatus(TaxiOrderDTO taxiOrderDTO, Long orderID);
    void deleteOrderByID(Long orderID);

}
