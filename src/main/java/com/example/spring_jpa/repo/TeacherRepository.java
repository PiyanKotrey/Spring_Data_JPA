package com.example.spring_jpa.repo;

import com.example.spring_jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Teacher findByName(String name);
}
