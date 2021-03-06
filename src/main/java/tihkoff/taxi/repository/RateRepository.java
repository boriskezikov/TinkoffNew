package tihkoff.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tihkoff.taxi.domain.RateEntity;

import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {
    void deleteAll();
}
