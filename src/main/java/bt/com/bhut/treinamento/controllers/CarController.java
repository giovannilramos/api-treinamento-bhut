package bt.com.bhut.treinamento.controllers;

import bt.com.bhut.treinamento.entities.Car;
import bt.com.bhut.treinamento.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.ArrayList;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService service;

    @PostMapping
    public Car save(@RequestBody Car entity) throws Exception {
        return this.service.save(entity);
    }

    @GetMapping
    public ArrayList<Car> getAll() throws AttributeNotFoundException {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable("id") Long id) throws AttributeNotFoundException {
        return this.service.getById(id);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable("id") Long id, @RequestBody Car entity) throws AttributeNotFoundException {
        return this.service.update(id, entity);
    }
}
