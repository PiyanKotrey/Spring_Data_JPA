package com.example.spring_jpa.service;

import com.example.spring_jpa.assembler.CourseModelAssembler;
import com.example.spring_jpa.entity.Course;
import com.example.spring_jpa.repo.CourseRepository;
import com.example.spring_jpa.repo.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService{
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final CourseModelAssembler courseModelAssembler;

    @Override
    public CollectionModel<?> findCourseById(Long id) {
        List<Course> courses =teacherRepository.findById(id).orElseThrow().getCourses();
        return courseModelAssembler.toCollectionModel(courses);
    }
}
