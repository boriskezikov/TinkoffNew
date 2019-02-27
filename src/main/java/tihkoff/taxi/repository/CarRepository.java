package tihkoff.taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tihkoff.taxi.domain.CarEntity;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    List<CarEntity> findAllByModelInfo(String model);
    CarEntity findDistinctByTechConditionIsGreaterThan(int tech);
    CarEntity getByCarId(long id);


}
