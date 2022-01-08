package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CarRepository extends JpaRepository<Car, Long> {
    boolean findByModel(String model);
    boolean findByYear(Integer year);
    ArrayList<Car> findAll();
}
