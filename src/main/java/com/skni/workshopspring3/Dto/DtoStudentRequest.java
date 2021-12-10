package com.skni.workshopspring3.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skni.workshopspring3.Entity.Course;
import com.skni.workshopspring3.Entity.GenderEnum;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class DtoStudentRequest {
    @NotNull
    @Size(min = 1,max = 20)
    @NotBlank
    private String firstName;
    @NotNull
    @Size(min = 1,max = 20)
    @NotBlank
    private String lastName;
    @NotBlank
    @NotNull
    private LocalDate date;
    @NotNull
    @Enumerated
    private GenderEnum gender;
    private Course course;
}
