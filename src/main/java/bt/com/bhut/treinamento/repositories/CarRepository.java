package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    ArrayList<Car> findAll();

    boolean existsCarByModelAndYear(String model, Integer year);
}
