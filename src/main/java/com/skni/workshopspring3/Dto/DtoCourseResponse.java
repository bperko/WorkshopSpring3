package com.skni.workshopspring3.Dto;

import com.skni.workshopspring3.Entity.CourseTypeEnum;

import javax.persistence.Enumerated;

public class DtoCourseResponse {
    String courseName;
    int year;
    String universityName;
    @Enumerated
    CourseTypeEnum courseType;
}
