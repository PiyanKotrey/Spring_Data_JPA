package com.example.spring_jpa.dto;

import com.example.spring_jpa.entity.Teacher;

public record CourseDto(Long id, String title, Teacher teacher) {
}
