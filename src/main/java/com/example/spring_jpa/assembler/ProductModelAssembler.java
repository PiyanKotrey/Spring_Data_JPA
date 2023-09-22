package com.example.spring_jpa.assembler;

import com.example.spring_jpa.controller.ProductController;
import com.example.spring_jpa.dto.ProductDto;
import com.example.spring_jpa.dto.TeacherDto;
import com.example.spring_jpa.entity.Product;
import com.example.spring_jpa.entity.Teacher;
import com.example.spring_jpa.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component

public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, EntityModel<ProductDto>> {
    private ProductMapper productMapper;
    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @SuppressWarnings("unchecked")
    public ProductModelAssembler() {
        super(ProductController.class,(Class<EntityModel<ProductDto>>) (Class<?>)EntityModel.class);
    }

    @Override
    public EntityModel<ProductDto> toModel(Product entity) {
        ProductDto productDto = productMapper.mapProductToProductDto(entity);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class)
                .findProductByUUID(entity.getUuid())).withSelfRel();

        Link collectionLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class)
                .findAllProduct()).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(productDto,selfLink,collectionLink);
    }

    @Override
    public CollectionModel<EntityModel<ProductDto>> toCollectionModel(Iterable<? extends Product> entities) {
        return super.toCollectionModel(entities);
    }

}
