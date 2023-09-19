package com.example.spring_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String uuid;
    @Column(name = "product_name",length = 100,nullable = false)
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;
    @ManyToMany
    @JoinTable(name = "product_prices",
            joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "price_id",referencedColumnName = "id"))
    private List<Price> prices;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
}
