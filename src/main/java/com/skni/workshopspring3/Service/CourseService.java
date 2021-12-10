package com.skni.workshopspring3.Service;

import com.skni.workshopspring3.Entity.Course;
import com.skni.workshopspring3.Entity.CourseTypeEnum;
import com.skni.workshopspring3.Repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    CourseRepository courseRepository;
    ModelMapper modelMapper;

    CourseService(CourseRepository courseRepository,ModelMapper modelMapper){
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }
    public Course addCourse(String name, int year, String universityName, CourseTypeEnum type){
        Course course = Course.builder().courseName(name).year(year).universityName(universityName).courseType(type).build();
        courseRepository.save(course);
        return course;
    }
}
