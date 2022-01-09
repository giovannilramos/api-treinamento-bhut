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

import java.util.ArrayList;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService service;

    @PostMapping
    public Item save(@RequestBody Item item) throws Exception {
        return this.service.save(item);
    }

    @GetMapping
    public ArrayList<Item> getAll() throws Exception {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable("id") Long id) throws Exception {
        return this.service.getById(id);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable("id") Long id, @RequestBody Item item) throws Exception {
        return this.service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.service.delete(id);
    }
}
