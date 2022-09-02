package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Types;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TypesRepository extends JpaRepository<Types, UUID> {

}
