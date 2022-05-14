package com.example.accessingdatarest.Service;

import com.example.accessingdatarest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.accessingdatarest.models.Order;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class OrderImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Override
    public Order findByOrderId(String orderId) {
        return null;
    }

    @Override
    public List<Order> findByUserId(Sort sort, String userId) {
        return null;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }
}
