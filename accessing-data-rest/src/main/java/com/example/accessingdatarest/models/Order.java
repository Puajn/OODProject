package com.example.accessingdatarest.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Document(collection = "orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @Id
    private String id;
    private String userId;
    private OrderStatus orderStatus;
    private List<Items> items ;

    public Order( String userId, List<Items> items,  String note) {
        this.userId = userId;
        this.orderStatus = OrderStatus.PENDING;
        this.items = items;
        this.totalCost = calculateTotalCost(this.items);
        this.note = note;
        this.creationTime = LocalDateTime.now();
        this.lastModifyTime = LocalDateTime.now();
        this.updateHistory.put(this.orderStatus, this.creationTime);
    }
    private double calculateTotalCost(List<Items> items) {
        double cost = 0;
        for(Items item : items) {
            cost += item.getPrice();
        }
        return cost;
    }
    private double totalCost;
    private String note;
    @CreatedDate
    private LocalDateTime creationTime;
    @LastModifiedDate
    private LocalDateTime lastModifyTime;

    private Map<OrderStatus, LocalDateTime> updateHistory = new HashMap<>();
}
