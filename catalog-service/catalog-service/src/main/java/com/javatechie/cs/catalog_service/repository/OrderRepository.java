package com.javatechie.cs.catalog_service.repository;

import com.javatechie.cs.catalog_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // ✅ Correct: Returns List for multiple matches
    List<Order> findByCategory(String category);

    // ✅ Add these if your Order entity has these fields
    List<Order> findByColor(String color);

   // List<Order> findByProduct(String product);

    // ✅ If Order entity has these fields and you expect single results
    // Order findByProductName(String productName); // Use distinct field names

    // Remove these - already provided by JpaRepository:
    // findAll(), count(), saveAll(), save(), deleteAll(), delete(), findById()


}
