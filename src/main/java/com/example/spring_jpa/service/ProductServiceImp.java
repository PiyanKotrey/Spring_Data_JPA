package com.example.spring_jpa.service;

import com.example.spring_jpa.assembler.ProductModelAssembler;
import com.example.spring_jpa.dto.CreateProductDto;
import com.example.spring_jpa.entity.Category;
import com.example.spring_jpa.entity.Product;
import com.example.spring_jpa.mapper.ProductMapper;
import com.example.spring_jpa.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{
    private final ProductRepository productRepository;
    private final ProductModelAssembler productModelAssembler;
    private final ProductMapper productMapper;
    @Override
    public CollectionModel<?> findProducts() {
        List<Product> products = productRepository.findAll();
        return productModelAssembler.toCollectionModel(products);
    }

    @Override
    public EntityModel<?> findByUUID(String uuid) {
        Product product = productRepository.findByUuid(uuid).orElseThrow();
        return productModelAssembler.toModel(product);
    }

    @Override
    public void createNewProduct(CreateProductDto createProductDto) {
        Product product = productMapper.mapCreateProductDtoToProduct(createProductDto);
        product.setUuid(UUID.randomUUID().toString());
        productRepository.save(product);
    }

    @Override
    public void updateProductByUuid(String uuid, CreateProductDto createProductDto) {
        Product product = productRepository.findByUuid(uuid).orElseThrow();
        productMapper.mapForPartialUpdate(product,createProductDto);
        productRepository.save(product);
    }

    @Override
    public void deleteProductByUuid(String uuid) {

    }
}
