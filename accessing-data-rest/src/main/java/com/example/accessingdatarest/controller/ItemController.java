package com.example.accessingdatarest.controller;

import com.example.accessingdatarest.Service.ItemsImpl;
import com.example.accessingdatarest.models.Items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    ItemsImpl itemService;

    @PostMapping("/addItem")
    public ResponseEntity<Items> addStudent(@RequestBody Items item) {
        try {
            Items itemNew = itemService.saveItem(item);
            return new ResponseEntity<>(itemNew, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateItemPrice/{id}")
    public ResponseEntity<?> updateItemPrice(@PathVariable("id") String id, @RequestBody Items  itemPrice)
    {
        Items updatedItem = itemService.updatePrice(id,itemPrice);
        if (updatedItem != null) {
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/sortedItems")
    public ResponseEntity<?> getTutorialById() {
        try {
            List<Items> iteList = itemService.sortItemsByPrice();
            if (iteList != null) {
                return new ResponseEntity<>(iteList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
         catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getItem")
    public ResponseEntity<?> getItemsById(@RequestParam String id ) {
        try {
            Items iteList = itemService.getItemsByID(id);
            if (iteList != null) {
                return new ResponseEntity<>(iteList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/deleteItem/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteItemById(@PathVariable("id") String id) {
        try {
            Items iteList = itemService.deleteItem(id);
            if (iteList != null) {
                return new ResponseEntity<>(iteList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
