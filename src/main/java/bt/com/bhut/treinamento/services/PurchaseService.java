package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Purchase;
import bt.com.bhut.treinamento.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository repository;

    public Purchase save(Purchase purchase) {
        return repository.save(purchase);
    }
}
