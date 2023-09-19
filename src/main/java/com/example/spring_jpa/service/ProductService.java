package com.example.spring_jpa.service;

import com.example.spring_jpa.dto.CreateProductDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface ProductService {
    CollectionModel<?> findProducts();

    EntityModel<?> findByUUID(String uuid);
    void createNewProduct(CreateProductDto createProductDto);
    void updateProductByUuid(String uuid,CreateProductDto createProductDto);
    void deleteProductByUuid(String uuid);
}
