package com.example.spring_jpa.controller;


import com.example.spring_jpa.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public CollectionModel<?> getAllTeacher(){
        return teacherService.findTeachers();
    }
    @GetMapping("/{id}")
    public EntityModel<?> getById(@PathVariable Long id){
        return teacherService.findById(id);
    }
}
