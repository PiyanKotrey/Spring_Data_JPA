package com.example.spring_jpa.controller;

import com.example.spring_jpa.dto.CreateProductDto;
import com.example.spring_jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public CollectionModel<?> findAllProduct(){
        return productService.findProducts();
    }
    @GetMapping("/{uuid}")
    public EntityModel<?> findProductByUUID(@PathVariable String uuid){
        return productService.findByUUID(uuid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProduct(@RequestBody CreateProductDto createProductDto){
        productService.createNewProduct(createProductDto);
    }

    @PatchMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable String uuid,@RequestBody CreateProductDto createProductDto){
        productService.updateProductByUuid(uuid,createProductDto);
    }
}
