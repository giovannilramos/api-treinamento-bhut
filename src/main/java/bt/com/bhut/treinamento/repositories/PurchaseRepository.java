package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
