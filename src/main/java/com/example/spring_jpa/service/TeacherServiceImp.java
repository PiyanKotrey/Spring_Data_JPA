package com.example.spring_jpa.service;

import com.example.spring_jpa.assembler.TeacherModelAssembler;
import com.example.spring_jpa.entity.Teacher;
import com.example.spring_jpa.repo.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImp implements TeacherService{
    private final TeacherRepository teacherRepository;
    private final TeacherModelAssembler teacherModelAssembler;
    @Override
    public CollectionModel<?> findTeachers(){
        List<Teacher> teacher = teacherRepository.findAll();
        return teacherModelAssembler.toCollectionModel(teacher);
    }
    @Override
    public EntityModel<?> findById(Long id){
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        return teacherModelAssembler.toModel(teacher);
    }
}
