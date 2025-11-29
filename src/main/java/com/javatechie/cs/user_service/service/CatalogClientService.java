package com.javatechie.cs.user_service.service;


import com.javatechie.cs.user_service.dto.OrderDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CatalogClientService {

    public static final String USER_SERVICE = "userService";
    private static final String BASE_URL = "http://localhost:8082/catalog/orders";

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "userService", fallbackMethod = "getOrdersFallback")
    public List<OrderDTO> getOrders(String category) {
        String url = (category == null || category.isBlank())
                ? BASE_URL
                : BASE_URL + "/category/" + category;

        OrderDTO[] response = restTemplate.getForObject(url, OrderDTO[].class);
        return response != null ? Arrays.asList(response) : Collections.emptyList();
    }

    // fallback must match: same args + Throwable at end
    public List<OrderDTO> getOrdersFallback(String category, Throwable t) {
        return Arrays.asList(
                new OrderDTO(1L, "mobile", "electronics", "white", 20000.0),
                new OrderDTO(2L, "T-shirt", "clothes", "black", 999.0),
                new OrderDTO(3L, "jeans", "clothes", "blue", 1999.0),
                new OrderDTO(4L, "watch", "accessories", "black", 4589.0),
                new OrderDTO(5L, "wallet", "accessories", "black", 6582.0),
                new OrderDTO(6L, "shoes", "footwear", "black", 6582.0)
        );
    }
}