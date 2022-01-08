package bt.com.bhut.treinamento.controllers;

import bt.com.bhut.treinamento.entities.CarEntity;
import bt.com.bhut.treinamento.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService service;

    @PostMapping
    public CarEntity save(CarEntity entity) {
        return this.service.save(entity);
    }

    @GetMapping
    public List<CarEntity> getAll() throws AttributeNotFoundException {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public CarEntity getById(@PathVariable("id") Long id) throws AttributeNotFoundException {
        return this.service.getById(id);
    }

    @PutMapping("/{id}")
    public CarEntity update(CarEntity entity) throws AttributeNotFoundException {
        return this.service.update(entity);
    }
}
