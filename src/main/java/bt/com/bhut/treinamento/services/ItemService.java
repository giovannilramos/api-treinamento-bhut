package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Item;
import bt.com.bhut.treinamento.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public Item save(Item item) {
        return repository.save(item);
    }
}
