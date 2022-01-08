package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Car;
import bt.com.bhut.treinamento.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.AttributeNotFoundException;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;

    public Car save(Car entity) {
        if(repository.findByModel(entity.getModel()) != null && repository.findByYear(entity.getYear()) != null) {
            throw new Error("Car already exists");
        }
       return this.repository.save(entity);
    }

    public List<Car> getAll() throws AttributeNotFoundException {
        if(repository.findAll().isEmpty()) {
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

    public Car update(Car entity) throws AttributeNotFoundException {
        if (!repository.findById(entity.getId()).isPresent()) {
            throw new AttributeNotFoundException("Car not found");
        }
        final var car = entity.builder()
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
        return this.repository.save(car);
    }
}
