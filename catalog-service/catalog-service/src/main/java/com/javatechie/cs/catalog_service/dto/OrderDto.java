package com.javatechie.cs.catalog_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String name;
    private String category;
    private String color;
    private double price;

    @Override
    public String toString() {
        return "OrderDto{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
