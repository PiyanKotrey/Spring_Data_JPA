package com.example.spring_jpa.repo;

import com.example.spring_jpa.entity.Course;
import com.example.spring_jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
