package com.example.spring_jpa;

import com.example.spring_jpa.entity.Category;
import com.example.spring_jpa.entity.Product;
import com.example.spring_jpa.repo.CategoryRepository;
import com.example.spring_jpa.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringJpaApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    void testFindByName() {
        List<Category>  categories = categoryRepository.findByName("Phone");
        categories.forEach(category -> System.out.println(category.getName()));
    }
    @Test
    void testFindCategoryByIdOrName() {
        List<Category>  categories = categoryRepository.findByIdOrName(1L,"Phone");
        categories.forEach(category -> System.out.println(category.getName()));
    }
    @Test
    void testFindCategoryByNameContains() {
        List<Category>  categories = categoryRepository.findByNameContains("ar");
        categories.forEach(category -> System.out.println(category.getName()));
    }
    @Test
    void testFindProductByUuidAndName() {
        Product product = productRepository.uuidName("99bff4bf-7285-4439-a1c7-d7ae54dc0a36","Apple");
        System.out.println(product.getName());
    }

}
