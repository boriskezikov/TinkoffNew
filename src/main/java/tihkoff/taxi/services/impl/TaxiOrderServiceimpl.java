package tihkoff.taxi.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tihkoff.taxi.domain.ClientEntity;
import tihkoff.taxi.domain.TariffEntity;
import tihkoff.taxi.domain.TaxiDriverEntity;
import tihkoff.taxi.domain.TaxiOrderEntity;
import tihkoff.taxi.dto.TaxiOrderDTO;
import tihkoff.taxi.mapper.TaxiOrderMapper;
import tihkoff.taxi.repository.TaxiOrderRepository;
import tihkoff.taxi.services.TaxiOrderService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaxiOrderServiceimpl implements TaxiOrderService {
    private final TaxiOrderRepository taxiOrderRepository;
    private final TaxiOrderMapper taxiOrderMapper;

    @Override
    public TaxiOrderDTO getByOrderID(Long orderID) {
        return taxiOrderRepository.findById(orderID)
                .map(taxiOrderMapper::taxiOrderEntityMap)
                .orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public List<TaxiOrderDTO> getByDriver(TaxiDriverEntity taxiDriverEntity) {
        return taxiOrderMapper
                .conveter(taxiOrderRepository
                        .getByTaxiDriverEntity(taxiDriverEntity));
    }

    @Override
    public List<TaxiOrderDTO> getByClientEntity(ClientEntity clientEntity) {
        return taxiOrderMapper
                .conveter(taxiOrderRepository
                        .getByClientEntity(clientEntity));
    }

    @Override
    public List<TaxiOrderDTO> getByTariff(TariffEntity tariffEntity) {
        return taxiOrderMapper
                .conveter(taxiOrderRepository
                        .getByTariffEntity(tariffEntity));
    }

    @Override
    public List<TaxiOrderDTO> getAll() {
        return taxiOrderMapper
                .conveter(taxiOrderRepository.findAll());
    }



    @Override
    public List<TaxiOrderDTO> getByOrderStatus(Integer orderStatus) {
        return taxiOrderMapper
                .conveter(taxiOrderRepository.getByStatus(orderStatus));
    }

    @Override
    public TaxiOrderDTO createOrder(TaxiOrderDTO taxiOrderDTO) {
       return taxiOrderMapper.taxiOrderEntityMap( taxiOrderRepository
                .save(taxiOrderMapper.taxiOrderEntityDTOmap(taxiOrderDTO)));

    }

    @Override
    public TaxiOrderDTO editOrder(TaxiOrderDTO taxiOrderDTO, Long orderID) {
        TaxiOrderEntity taxiOrderEntity = taxiOrderMapper.taxiOrderEntityDTOmap(getByOrderID(orderID));
        taxiOrderDTO.setId(orderID);
        return taxiOrderMapper
                .taxiOrderEntityMap(taxiOrderRepository
                        .save(taxiOrderMapper
                                .updateOrder(taxiOrderDTO,taxiOrderEntity)));
    }

    @Override
    public TaxiOrderDTO editStatus(TaxiOrderDTO taxiOrderDTO, Long orderID) {
        TaxiOrderEntity taxiOrderEntity = taxiOrderMapper.taxiOrderEntityDTOmap(getByOrderID(orderID));
        return taxiOrderMapper
                .taxiOrderEntityMap(taxiOrderRepository
                        .save(taxiOrderMapper.updateOrder(taxiOrderDTO,taxiOrderEntity)));
    }


    @Override
    public void deleteOrderByID(Long orderID) {
        taxiOrderRepository.deleteById(orderID);

    }
}
