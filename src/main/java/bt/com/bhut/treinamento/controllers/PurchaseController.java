package bt.com.bhut.treinamento.controllers;

import bt.com.bhut.treinamento.entities.Purchase;
import bt.com.bhut.treinamento.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService service;

    @PostMapping
    public Purchase save(@RequestBody Purchase purchase) {
        return this.service.save(purchase);
    }

    @GetMapping
    public ArrayList<Purchase> getAll() throws Exception {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Purchase getById(@PathVariable("id") Long id) throws Exception {
        return this.service.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.service.delete(id);
    }
}
