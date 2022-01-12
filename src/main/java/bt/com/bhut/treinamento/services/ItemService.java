package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Item;
import bt.com.bhut.treinamento.repositories.ItemRepository;
import bt.com.bhut.treinamento.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    public Item save(Item item) throws Exception {
        return repository.save(item);
    }

    public ArrayList<Item> getAll() throws Exception {
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

    public Item update(Long id, Item item) throws Exception {
        Optional<Item> findItem = repository.findById(id);
        if (!findItem.isPresent()) {
            throw new Exception("Item not found");
        }
        return findItem.map(el -> {
            el.setQuantity(item.getQuantity());
            el.setPrice(item.getPrice());
            return repository.save(el);
        }).get();
    }

    public void delete(Long id) throws Exception {
        Optional<Item> item = repository.findById(id);
        if (!item.isPresent()) {
            throw new Exception("Purchase and Item not found");
        }
        repository.delete(item.get());
    }
}
