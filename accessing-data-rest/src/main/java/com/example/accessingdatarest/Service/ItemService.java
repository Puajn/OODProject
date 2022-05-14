package com.example.accessingdatarest.Service;

import com.example.accessingdatarest.models.Items;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Items saveItem(Items product);
    Items deleteItem(String id);
    Items updatePrice(String id, Items itemToBeUpdated);
    List<Items> sortItemsByPrice();
    Items getItemsByID(String id);
}
