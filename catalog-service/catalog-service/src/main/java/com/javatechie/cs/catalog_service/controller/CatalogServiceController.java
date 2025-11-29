package com.javatechie.cs.catalog_service.controller;

import com.javatechie.cs.catalog_service.entity.Order;
import com.javatechie.cs.catalog_service.service.CatalogService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogServiceController {

    @Autowired
    private CatalogService catalogService;

    @PostConstruct
    public void initOrdersTable() {
        catalogService.initOrdersTable();
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = catalogService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/orders/category/{category}")
    public ResponseEntity<List<Order>> getOrdersByCategory(@PathVariable String category) {
        List<Order> orders = catalogService.getOrdersByCategory(category);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // To insert elements in the table
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = catalogService.createOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}