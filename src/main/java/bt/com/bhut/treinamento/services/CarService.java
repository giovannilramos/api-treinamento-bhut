package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Car;
import bt.com.bhut.treinamento.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.AttributeNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;

    public Car save(Car entity) throws Exception {
        try {
            return this.repository.save(entity);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public ArrayList<Car> getAll() throws AttributeNotFoundException {
        if (repository.findAll().isEmpty()) {
            throw new AttributeNotFoundException("Cars not found");
        }
        return repository.findAll();
    }

    public Car getById(Long id) throws AttributeNotFoundException {
        if (!repository.findById(id).isPresent()) {
            throw new AttributeNotFoundException("Car not found");
        }
        return repository.findById(id).get();
    }

    public Car update(Long id, Car entity) throws AttributeNotFoundException {
        Optional<Car> carId = repository.findById(id);
        if (!carId.isPresent()) {
            throw new AttributeNotFoundException("Car not found");
        }
        Car car = carId.get();
        car.setName(entity.getName());
        car.setPrice(entity.getPrice());
        return repository.save(car);
    }
}
