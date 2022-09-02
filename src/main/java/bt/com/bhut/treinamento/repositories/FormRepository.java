package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormRepository extends JpaRepository<Form, UUID> {

}
