package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByModel(String model);
    Car findByYear(int year);
}
