package tihkoff.taxi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tihkoff.taxi.domain.TaxiDriverEntity;

@Repository
public interface TaxiDriverEntityRepository extends JpaRepository<TaxiDriverEntity, Long> {

}
