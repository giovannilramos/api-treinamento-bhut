package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    ArrayList<Purchase> findAll();
}
