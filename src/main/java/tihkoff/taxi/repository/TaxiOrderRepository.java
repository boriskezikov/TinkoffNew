package tihkoff.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tihkoff.taxi.domain.TaxiOrderEntity;

@Repository
public interface TaxiOrderRepository extends JpaRepository<TaxiOrderEntity, Long> {
}
