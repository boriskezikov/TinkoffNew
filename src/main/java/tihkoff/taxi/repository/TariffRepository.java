package tihkoff.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tihkoff.taxi.domain.TariffEntity;

@Repository
public interface TariffRepository extends JpaRepository<TariffEntity, Long> {
}
