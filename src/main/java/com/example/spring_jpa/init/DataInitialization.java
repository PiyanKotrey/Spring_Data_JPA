//package com.example.spring_jpa.init;
//
//import com.example.spring_jpa.entity.Category;
//import com.example.spring_jpa.entity.Price;
//import com.example.spring_jpa.entity.Product;
//import com.example.spring_jpa.repo.CategoryRepository;
//import com.example.spring_jpa.repo.PriceRepository;
//import com.example.spring_jpa.repo.ProductRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.UUID;
//
//@Component
//@RequiredArgsConstructor
//public class DataInitialization {
//    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private final PriceRepository priceRepository;
//    @PostConstruct
//    void init(){
//        System.out.println("hello kon paapaa");
//
//        Category car = Category.builder().name("Car").build();
//        Category phone = Category.builder().name("Phone").build();
//        categoryRepository.saveAll(List.of(car,phone));
//
//        Price defaultPrice = Price.builder()
//                .priceIn(BigDecimal.valueOf(3000))
//                .priceOut(BigDecimal.valueOf(3500))
//                .build();
//
//        Price specialPrice = Price.builder()
//                .priceIn(BigDecimal.valueOf(2000))
//                .priceOut(BigDecimal.valueOf(2500))
//                .build();
//        priceRepository.saveAll(List.of(defaultPrice,specialPrice));
//
//        Product product1 = Product.builder()
//                .name("Lambo")
//                .description("Lambo is most the Car")
//                .uuid(UUID.randomUUID().toString())
//                .category(car)
//                .prices(List.of(specialPrice,defaultPrice))
//                .build();
//        Product product2 = Product.builder()
//                .name("Apple")
//                .description("is iphone")
//                .uuid(UUID.randomUUID().toString())
//                .category(phone)
//                .prices(List.of(specialPrice,defaultPrice))
//                .build();
//        Product product3 = Product.builder()
//                .name("Luxis")
//                .description("is the legend car")
//                .uuid(UUID.randomUUID().toString())
//                .category(car)
//                .prices(List.of(specialPrice,defaultPrice))
//                .build();
//        productRepository.save(product1);
//        productRepository.save(product2);
//        productRepository.save(product3);
//        List<Product> products = productRepository.findAll();
//        products.forEach(product -> System.out.println(product.getName()));
//    }
//}
