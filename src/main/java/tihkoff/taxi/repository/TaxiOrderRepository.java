package tihkoff.taxi.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tihkoff.taxi.domain.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaxiOrderRepository extends JpaRepository<TaxiOrderEntity, Long> {
    @Override
    @EntityGraph("order-entity-graph")
    List<TaxiOrderEntity> findAll();

    List<TaxiOrderEntity> getByClientEntity(ClientEntity clientEntity);
    List<TaxiOrderEntity> getByTariffEntity (TariffEntity tariffEntity);
    List<TaxiOrderEntity>getByTaxiDriverEntity(TaxiDriverEntity taxiDriverEntity);
    List<TaxiOrderEntity>getByStatus(Integer status);
}
