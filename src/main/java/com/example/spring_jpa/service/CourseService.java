package com.example.spring_jpa.service;

import com.example.spring_jpa.entity.Teacher;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface CourseService {
    CollectionModel<?> findCourseById(Long id);
}
