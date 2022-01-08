package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Car;
import bt.com.bhut.treinamento.entities.User;
import bt.com.bhut.treinamento.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.AttributeNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User save(User entity) {
        return repository.save(entity);
    }

    public ArrayList<User> getAll() throws AttributeNotFoundException {
        if (repository.findAll().isEmpty()) {
            throw new AttributeNotFoundException("Users not found");
        }
        return repository.findAll();
    }

    public User getById(Long id) throws AttributeNotFoundException {
        if (!repository.findById(id).isPresent()) {
            throw new AttributeNotFoundException("User not found");
        }
        return repository.findById(id).get();
    }

    public User getByEmail(String email) throws AttributeNotFoundException {
        if (repository.findByEmail(email) == null || repository.findByEmail(email).equals("")) {
            throw new AttributeNotFoundException("User not found");
        }
        return repository.findByEmail(email);
    }

    public User update(Long id, User entity) throws AttributeNotFoundException {
        Optional<User> userId = repository.findById(id);
        if (!userId.isPresent()) {
            throw new AttributeNotFoundException("User not found");
        }
        User user = userId.get();
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        return repository.save(user);
    }

    public void delete(Long id) throws AttributeNotFoundException {
        Optional<User> userId = repository.findById(id);
        if (!userId.isPresent()) {
            throw new AttributeNotFoundException("User not found");
        }
        repository.delete(userId.get());
    }
}
