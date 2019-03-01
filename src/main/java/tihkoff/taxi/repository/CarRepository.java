package tihkoff.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tihkoff.taxi.domain.CarEntity;
import tihkoff.taxi.dto.CarEntityDTO;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    List<CarEntity> getCarEntitiesByCategory(int category);
    List<CarEntity> findAllByTechConditionIsGreaterThan(int tech);
    CarEntity getByCarId(long id);




}
