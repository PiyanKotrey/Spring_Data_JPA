package com.example.spring_jpa.assembler;

import com.example.spring_jpa.controller.CourseController;
import com.example.spring_jpa.dto.CourseDto;
import com.example.spring_jpa.entity.Course;
import com.example.spring_jpa.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CourseModelAssembler extends RepresentationModelAssemblerSupport<Course, EntityModel<CourseDto>> {
    @Autowired
    private CourseMapper courseMapper;

    @SuppressWarnings("unchecked")
    public CourseModelAssembler(){
        super(CourseController.class,(Class<EntityModel<CourseDto>>) (Class<?>)EntityModel.class);
    }

    @Override
    public CollectionModel<EntityModel<CourseDto>> toCollectionModel(Iterable<? extends Course> entities) {
        return super.toCollectionModel(entities);
    }

    @Override
    public EntityModel<CourseDto> toModel(Course entity) {
        CourseDto courseDto = courseMapper.mapCourseToDto(entity);
        return EntityModel.of(courseDto);
    }
}
