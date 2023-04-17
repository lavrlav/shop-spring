package com.example.shopspring.repository;

import com.example.shopspring.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemModel, Long> {
    ItemModel findById(long id);
}
