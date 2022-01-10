package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    ArrayList<User> findAll();
}
