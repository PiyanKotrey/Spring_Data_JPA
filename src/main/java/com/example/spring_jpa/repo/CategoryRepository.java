package com.example.spring_jpa.repo;

import com.example.spring_jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findByName(String name);
    List<Category> findByIdOrName(Long id,String name);
    List<Category> findByNameContains(String name);
}
