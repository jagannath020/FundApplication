package com.javatechie.cs.catalog_service.service;

import com.javatechie.cs.catalog_service.entity.Order;
import com.javatechie.cs.catalog_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByCategory(String category) {
        return orderRepository.findByCategory(category);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public long getOrderCount() {
        return orderRepository.count();
    }

    public void initOrdersTable() {
        if (getOrderCount() == 0) {
            orderRepository.saveAll(List.of(
                    new Order("mobile", "electronics", "white", 20000.0),
                    new Order("T-shirt", "clothes", "black", 999.0),
                    new Order("jeans", "clothes", "blue", 1999.0),
                    new Order("watch", "accessories", "black", 4589.0),
                    new Order("wallet", "accessories", "black", 6582.0),
                    new Order("shoes", "footwear", "black", 6582.0)
            ));
        }
    }
}
