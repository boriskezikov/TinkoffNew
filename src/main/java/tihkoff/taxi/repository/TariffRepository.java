package tihkoff.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tihkoff.taxi.domain.TariffEntity;

import java.util.List;


@Repository
public interface TariffRepository extends JpaRepository<TariffEntity, Integer> {


    void deleteByTariffId(Integer tariffID);
    void deleteAll();
    List<TariffEntity> getByPriceLessThan(Integer price);
    List<TariffEntity> getByPriceGreaterThan(Integer price);
}
