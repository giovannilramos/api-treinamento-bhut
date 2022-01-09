package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Purchase;
import bt.com.bhut.treinamento.repositories.ItemRepository;
import bt.com.bhut.treinamento.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository repository;
    @Autowired
    private ItemRepository itemRepository;

    public Purchase save(Purchase purchase, List<Long> itemId) throws Exception {
        if (!itemRepository.findById(itemId).isPresent()) {
            throw new Exception("Purchase not found");
        }
        return itemRepository.findById(itemId).map(el -> {
            purchase.setItem
            return
        }).get();
    }

    public Purchase getById(Long id) throws Exception {
        Optional<Purchase> purchase = repository.findById(id);
        if (!purchase.isPresent()) {
            throw new Exception("Purchase not found");
        }
        return purchase.get();
    }

    public List<Purchase> getAll() throws Exception {
        if (repository.findAll().isEmpty()) {
            throw new Exception("Purchases not found");
        }
        return repository.findAll();
    }

    public void delete(Long id) throws Exception {
        Optional<Purchase> purchase = repository.findById(id);
        if (!purchase.isPresent()) {
            throw new Exception("Purchase not found");
        }
        repository.delete(purchase.get());
    }

}
