package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    boolean findByModelYear(String model, int year);
}
