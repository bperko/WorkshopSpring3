package com.skni.workshopspring3.Controller;

import com.skni.workshopspring3.Dto.DtoCourseRequest;
import com.skni.workshopspring3.Entity.Course;
import com.skni.workshopspring3.Service.CourseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CourseController {

    CourseService courseService;
    ModelMapper modelMapper;

    @PostMapping("/addCourse")
    public void addCourse(@RequestBody Course course){
        DtoCourseRequest dtoCourseRequest = modelMapper.map(course,DtoCourseRequest.class);
        courseService.addCourse(dtoCourseRequest.getCourseName(),dtoCourseRequest.getYear(),dtoCourseRequest.getUniversityName(),dtoCourseRequest.getCourseType());
    }
}
