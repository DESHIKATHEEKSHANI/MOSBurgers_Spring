package edu.icet.ecom.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String category;

    @Column(nullable = false)
    private String image;
}