package com.example.spring_jpa.mapper;

import com.example.spring_jpa.dto.CreateProductDto;
import com.example.spring_jpa.dto.ProductDto;
import com.example.spring_jpa.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapForPartialUpdate(@MappingTarget Product product, CreateProductDto createProductDto);
    @Mapping(source = "categoryId",target = "category.id")
    Product mapCreateProductDtoToProduct(CreateProductDto createProductDto);
    ProductDto mapProductToProductDto(Product product);
    List<ProductDto> mapProductsToProductDtoList(List<Product> productList);
}
