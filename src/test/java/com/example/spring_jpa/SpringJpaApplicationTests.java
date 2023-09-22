package com.example.spring_jpa;

import com.example.spring_jpa.dto.TeacherDto;
import com.example.spring_jpa.entity.Category;
import com.example.spring_jpa.entity.Product;
import com.example.spring_jpa.entity.Teacher;
import com.example.spring_jpa.mapper.TeacherMapper;
import com.example.spring_jpa.repo.CategoryRepository;
import com.example.spring_jpa.repo.ProductRepository;
import com.example.spring_jpa.repo.TeacherRepository;
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
    @Autowired
    private TeacherRepository teacherRepository;
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

    @Test
    void testFindTeacher(){
        List<Teacher> teachers = teacherRepository.findAll();
        System.out.println(teachers);

    }

}
