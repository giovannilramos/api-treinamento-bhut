package bt.com.bhut.treinamento.controllers;

import bt.com.bhut.treinamento.entities.Item;
import bt.com.bhut.treinamento.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService service;

    @PostMapping
    public Item save(@RequestBody Item item) {
        return this.service.save(item);
    }
}
