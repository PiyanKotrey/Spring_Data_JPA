package com.example.spring_jpa.controller;

import com.example.spring_jpa.entity.Teacher;
import com.example.spring_jpa.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/{id}")
    public CollectionModel<?> getByTeacherId(@PathVariable Long id){
        return courseService.findCourseById(id);
    }
}
