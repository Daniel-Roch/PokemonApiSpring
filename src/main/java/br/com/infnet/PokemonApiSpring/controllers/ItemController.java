package br.com.infnet.PokemonApiSpring.controllers;

import br.com.infnet.PokemonApiSpring.model.Item;
import br.com.infnet.PokemonApiSpring.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    Logger logger = LoggerFactory.getLogger(ItemController.class);

    @GetMapping
    public List<Item> getAll(){
        logger.info("GET ALL ITEM");
        return itemService.getAll();
    }

    @PostMapping
    public String saveItem(@RequestBody Item item){
        logger.info("ADD ITEM");
        itemService.addItem(item);
        return "Ability add success";
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id){
        logger.info("DELETE ITEM ID: " + id);
        itemService.removeById(id);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable int id, @RequestBody Item item){
        logger.info("UPDATE ITEM ID: " + id);
        itemService.updateItem(id, item);
    }
}
