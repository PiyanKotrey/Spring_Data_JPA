package com.example.spring_jpa.repo;

import com.example.spring_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByUuid(String uuid);
    @Transactional
    @Modifying
    @Query("SELECT p FROM Product AS p WHERE p.uuid=:uuid and p.name=:name")
    Product uuidName(String uuid,String name);


}
