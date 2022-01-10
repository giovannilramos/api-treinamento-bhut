package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Item;
import bt.com.bhut.treinamento.entities.Purchase;
import bt.com.bhut.treinamento.repositories.ItemRepository;
import bt.com.bhut.treinamento.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository repository;
    @Autowired
    private ItemRepository itemRepository;

    public Purchase save(Purchase purchase) {
        Double amount = purchase.getItems().stream().mapToDouble(el -> {
            Optional<Item> item = itemRepository.findById(el.getId());
            return item.get().getPrice() * item.get().getQuantity();
        }).sum();
        purchase.setAmount(amount);
        return repository.save(purchase);
    }

    public Purchase getById(Long id) throws Exception {
        Optional<Purchase> purchase = repository.findById(id);
        if (!purchase.isPresent()) {
            throw new Exception("Purchase not found");
        }
        Double amount = purchase.get().getItems().stream().mapToDouble(el -> {
            return el.getPrice() * el.getQuantity();
        }).sum();
        purchase.get().setAmount(amount);
        return purchase.get();
    }

    public ArrayList<Purchase> getAll() throws Exception {
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
