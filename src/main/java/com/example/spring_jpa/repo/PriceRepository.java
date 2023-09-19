package com.example.spring_jpa.repo;

import com.example.spring_jpa.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Long> {
}
