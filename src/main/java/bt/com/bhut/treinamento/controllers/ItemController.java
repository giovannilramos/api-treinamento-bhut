package bt.com.bhut.treinamento.controllers;

import bt.com.bhut.treinamento.entities.Item;
import bt.com.bhut.treinamento.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService service;

    @PostMapping("/purchase/{purchaseId}/item")
    public Item save(@RequestBody Item item, @PathVariable("purchaseId") Long purchaseId) throws Exception {
        return this.service.save(item, purchaseId);
    }

    @GetMapping
    public List<Item> getAll() throws Exception {
        return this.service.getAll();
    }

    @GetMapping("/purchase/{purchaseId}/item/{id}")
    public Item getById(@PathVariable("id") Long id) throws Exception {
        return this.service.getById(id);
    }

    @PutMapping("/purchase/{purchaseId}/item/{id}")
    public Item update(@PathVariable("id") Long id, @PathVariable("purchaseId") Long purchaseId, @RequestBody Item item) throws Exception {
        return this.service.update(id, item, purchaseId);
    }

    @DeleteMapping("/purchase/{purchaseId}/delete/item/{id}")
    public void delete(@PathVariable("id") Long id, @PathVariable("purchaseId") Long purchaseId) throws Exception {
        this.service.delete(id, purchaseId);
    }
}
