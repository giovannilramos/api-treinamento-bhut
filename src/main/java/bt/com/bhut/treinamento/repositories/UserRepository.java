package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    ArrayList<User> findAll();
}
