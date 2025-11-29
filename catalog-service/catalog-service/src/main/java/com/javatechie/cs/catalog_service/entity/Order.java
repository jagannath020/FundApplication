package com.javatechie.cs.catalog_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private double price;

    // ✅ CUSTOM CONSTRUCTOR (no id)
    public Order(String name, String category, String color, double price) {
        this.name = name;
        this.category = category;
        this.color = color;
        this.price = price;
    }
}
