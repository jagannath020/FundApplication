package com.javatechie.cs.user_service.controller;


import com.javatechie.cs.user_service.dto.OrderDTO;
import com.javatechie.cs.user_service.service.CatalogClientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/user-service")
public class CatalogClientController {

    @Autowired
    private CatalogClientService catalogClientService;

    @GetMapping("/displayOrders/category/{category}")
    public List<OrderDTO> displayOrders(@PathVariable(value = "category", required = false) String category) {
        return catalogClientService.getOrders(category);
    }
}