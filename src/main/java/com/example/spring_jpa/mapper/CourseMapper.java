package com.example.spring_jpa.mapper;

import com.example.spring_jpa.dto.CourseDto;
import com.example.spring_jpa.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto mapCourseToDto(Course course);
}
