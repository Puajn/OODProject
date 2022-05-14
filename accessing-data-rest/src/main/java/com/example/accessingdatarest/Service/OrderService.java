package com.example.accessingdatarest.Service;

import com.example.accessingdatarest.models.Order;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface OrderService {
    Order findByOrderId(String orderId);

    List<Order> findByUserId(Sort sort, String userId);

    Order saveOrder(Order order);

}
