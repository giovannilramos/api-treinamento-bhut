package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ItemRepository extends JpaRepository<Item, Long> {
    ArrayList<Item> findAll();
}
