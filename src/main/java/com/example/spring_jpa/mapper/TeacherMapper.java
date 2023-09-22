package com.example.spring_jpa.mapper;

import com.example.spring_jpa.dto.TeacherDto;
import com.example.spring_jpa.entity.Teacher;
import com.example.spring_jpa.repo.TeacherRepository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto mapTeacherToDto(Teacher teacher);
    List<TeacherDto> mapTeacherListToDtoList(List<Teacher> teachers);
}
