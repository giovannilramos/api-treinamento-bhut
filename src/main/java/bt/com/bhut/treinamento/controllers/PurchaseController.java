package bt.com.bhut.treinamento.controllers;

import bt.com.bhut.treinamento.entities.Purchase;
import bt.com.bhut.treinamento.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService service;

    @PostMapping
    public Purchase save(@RequestBody Purchase purchase) {
        return this.service.save(purchase);
    }
}
