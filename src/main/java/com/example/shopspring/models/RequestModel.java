package com.example.shopspring.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "request_model")
public class RequestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="p_name")
    private String name;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="item_id")
    private Long itemId;


}

