package com.example.accessingdatarest.controller;

import com.example.accessingdatarest.Service.OrderImpl;
import com.example.accessingdatarest.models.Items;
import com.example.accessingdatarest.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderImpl orderService;

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        try {
            Order orderNew = this.orderService.saveOrder(order);
            return new ResponseEntity<>(orderNew, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
