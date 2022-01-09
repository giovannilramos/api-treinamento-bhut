package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Item;
import bt.com.bhut.treinamento.entities.Purchase;
import bt.com.bhut.treinamento.repositories.ItemRepository;
import bt.com.bhut.treinamento.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    public Item save(Item item, Long purchaseId) throws Exception {
        if (!purchaseRepository.findById(purchaseId).isPresent()) {
            throw new Exception("Purchase not found");
        }
        return purchaseRepository.findById(purchaseId).map(el -> {
            item.setPurchase(el);
            return repository.save(item);
        }).get();
    }

    public List<Item> getAll() throws Exception {
        if (repository.findAll().isEmpty()) {
            throw new Exception("Items not found");
        }
        return repository.findAll();
    }

    public Item getById(Long id) throws Exception {
        if (!repository.findById(id).isPresent()) {
            throw new Exception("Item not found");
        }
        return repository.findById(id).get();
    }

    public Item update(Long id, Item item, Long purchaseId) throws Exception {
        Optional<Purchase> purchase = purchaseRepository.findById(purchaseId);
        Optional<Item> findItem = repository.findById(id);
        if (!purchase.isPresent()) {
            throw new Exception("Purchase not found");
        } else if (!findItem.isPresent()) {
            throw new Exception("Item not found");
        }

        return findItem.map(el -> {
            item.setQuantity(el.getQuantity());
            item.setPrice(el.getPrice());
            return repository.save(item);
        }).get();
    }

    public void delete(Long id, Long purchaseId) throws Exception {
        Optional<Item> itemAndPurchase = repository.findByIdAndPurchaseId(id, purchaseId);
        if (!itemAndPurchase.isPresent()) {
            throw new Exception("Purchase and Item not found");
        }
        itemAndPurchase.map(el -> {
            repository.delete(el);
            return ResponseEntity.ok().build();
        });
    }
}
