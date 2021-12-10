package com.skni.workshopspring3.Dto;

import com.skni.workshopspring3.Entity.CourseTypeEnum;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
public class DtoCourseRequest {
    @NotBlank
    String courseName;
    @NotBlank
    int year;
    @NotBlank
    String universityName;
    @NotBlank
    @Enumerated
    CourseTypeEnum courseType;
}
