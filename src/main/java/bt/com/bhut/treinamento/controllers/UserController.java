package bt.com.bhut.treinamento.controllers;

import bt.com.bhut.treinamento.entities.User;
import bt.com.bhut.treinamento.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.AttributeNotFoundException;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public User save(@RequestBody User entity) throws Exception {
        return this.service.save(entity);
    }

    @GetMapping
    public ArrayList<User> getAll() throws AttributeNotFoundException {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) throws AttributeNotFoundException {
        return this.service.getById(id);
    }

    @GetMapping("/email/{email}")
    public User getById(@PathVariable("email") String email) throws AttributeNotFoundException {
        return this.service.getByEmail(email);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User entity) throws AttributeNotFoundException {
        return this.service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws AttributeNotFoundException {
        this.service.delete(id);
    }
}
