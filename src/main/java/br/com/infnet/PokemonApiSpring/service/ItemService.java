package br.com.infnet.PokemonApiSpring.service;

import br.com.infnet.PokemonApiSpring.exception.ItemNotFound;
import br.com.infnet.PokemonApiSpring.model.Item;
import br.com.infnet.PokemonApiSpring.util.ItemApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    Logger logger = LoggerFactory.getLogger(ItemService.class);
    private List<Item> listItems = initItems();

    private List<Item> initItems() {
        logger.info("5 items");
        ArrayList<Item> items = new ArrayList<>();
        ItemApi itemApi = new ItemApi();
        for(int i = 1; i <= 5; i++){
            logger.debug("Get " + i + " Items");
            try{
                Item item = itemApi.getById(i);
                items.add(item);
            }catch(ItemNotFound e) {
                logger.error("Error: " + e);
            }
        }
        return items;
    }

    public List<Item> getAll() { return listItems; }
    public void addItem(Item item) { listItems.add(item); }
    public void removeById(int id) { listItems.remove(id); }
    public void updateItem(int id, Item item) {
        listItems.set(id, item);
    }
}
