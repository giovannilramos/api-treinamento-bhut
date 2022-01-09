package bt.com.bhut.treinamento.repositories;

import bt.com.bhut.treinamento.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByPurchaseId(Long id);
    Optional<Item> findByIdAndPurchaseId(Long id, Long purchaseId);

    Optional<Item> findById(List<Long> itemId);
}
