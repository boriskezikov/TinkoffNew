package tihkoff.taxi.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tihkoff.taxi.domain.ClientEntity;

import javax.persistence.NamedEntityGraph;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, String> {
    Optional<ClientEntity> findByPhoneNumber(String phone);
    void deleteByPhoneNumber(String phone);

}
