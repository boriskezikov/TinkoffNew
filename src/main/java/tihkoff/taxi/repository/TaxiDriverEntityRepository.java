package tihkoff.taxi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tihkoff.taxi.domain.TaxiDriverEntity;

import java.util.Optional;

@Repository
public interface TaxiDriverEntityRepository extends JpaRepository<TaxiDriverEntity, Long> {
    Optional<TaxiDriverEntity> getByLicenseNumber(String licence);
    Optional<TaxiDriverEntity> getByPassport(String licence);
    void deleteByPassport(String passport);
    void deleteByLicenseNumber(String licence);

}
