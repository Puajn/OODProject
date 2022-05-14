package com.example.accessingdatarest.Service;

import com.example.accessingdatarest.models.Items;
import com.example.accessingdatarest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemsImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepo;

    @Override
    public Items saveItem(Items item) {
        Items itemNew = itemRepo.save(new Items(item.getItemName(),item.getQuantity(),item.getType(),item.getCuisine(),item.getPrice(),item.getHall()));
        return itemNew;
    }

    @Override
    public Items deleteItem(String id) {
        Items item = itemRepo.findByItemID(id);
        itemRepo.deleteById(id);
        return item;
    }

    @Override
    public Items updatePrice(String id, Items itemUpdated) {
        Items item = itemRepo.findByItemID(id);
        item.setPrice(itemUpdated.getPrice());
        itemRepo.save(item);
        return item;
}

    @Override
    public Items getItemsByID(String id) {
        Items item = itemRepo.findByItemID(id);
        return item;
    }

    @Override
    public List<Items> sortItemsByPrice() {
        List<Items> itemList = itemRepo.findAll(Sort.by(Sort.Direction.ASC,"Price"));
        return itemList;
    }
}
