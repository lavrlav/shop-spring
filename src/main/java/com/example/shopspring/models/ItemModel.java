package com.example.shopspring.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item_model")
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "disc")
    private String disc;

    @Column(name = "url")
    private String url;

    @Column(name="add_time")
    Long time;

    @Column(name = "type")
    private String type;

    private String timeFormat;


}
