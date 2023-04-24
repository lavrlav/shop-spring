package com.example.shopspring.repository;

import com.example.shopspring.models.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestModel, Long> {
}
