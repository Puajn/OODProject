package com.example.accessingdatarest.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "items")
public class Items {
    @Id
    private String itemID;
    private String itemName;
    private int quantity;
    private FoodType type;
    private Cuisine cuisine;
    private double price;
    private DinningHall hall;
    public Items(String itemName, int quantity, FoodType type, Cuisine cuisine, double price,DinningHall hall) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.type = type;
        this.cuisine = cuisine;
        this.price = price;
        this.hall = hall;
    }
}
