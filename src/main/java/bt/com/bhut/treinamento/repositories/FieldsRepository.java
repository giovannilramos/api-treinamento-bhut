package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Fields;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FieldsRepository extends JpaRepository<Fields, UUID> {

}
