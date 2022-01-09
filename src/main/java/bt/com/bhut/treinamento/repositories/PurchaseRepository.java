package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    ArrayList<Purchase> findAll();
}
