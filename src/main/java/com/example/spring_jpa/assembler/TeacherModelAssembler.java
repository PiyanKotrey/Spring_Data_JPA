package com.example.spring_jpa.assembler;

import com.example.spring_jpa.controller.CourseController;
import com.example.spring_jpa.controller.TeacherController;
import com.example.spring_jpa.dto.TeacherDto;
import com.example.spring_jpa.entity.Teacher;
import com.example.spring_jpa.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class TeacherModelAssembler extends RepresentationModelAssemblerSupport<Teacher, EntityModel<TeacherDto>> {
    @Autowired
    private TeacherMapper teacherMapper;

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @SuppressWarnings("unchecked")
    public TeacherModelAssembler(){
        super(TeacherController.class,(Class<EntityModel<TeacherDto>>)(Class<?>) EntityModel.class);
    }


    @Override
    public EntityModel<TeacherDto> toModel(Teacher entity) {
        TeacherDto teacherDto = teacherMapper.mapTeacherToDto(entity);
        Link collectionLike = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeacherController.class)
                        .getAllTeacher()).withRel(IanaLinkRelations.COLLECTION);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeacherController.class)
                .getById(entity.getId())).withSelfRel();
        Link courseLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class)
                        .getByTeacherId(entity.getId())).withSelfRel();
        return EntityModel.of(teacherDto,collectionLike,selfLink,courseLink);
    }

    @Override
    public CollectionModel<EntityModel<TeacherDto>> toCollectionModel(Iterable<? extends Teacher> entities) {
        return super.toCollectionModel(entities);
    }
}
