package com.javatechie.cs.user_service.dto;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String name;      // or productName
    private String category;
    private String color;
    private Double price;
}
