package com.example.spring_jpa.dto;

import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "products",itemRelation = "product")
public record ProductDto(String uuid,
                         String name,
                         String description) {
}
