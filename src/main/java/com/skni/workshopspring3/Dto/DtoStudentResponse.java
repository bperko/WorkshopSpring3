package com.skni.workshopspring3.Dto;

import com.skni.workshopspring3.Entity.GenderEnum;
import lombok.Data;

import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
public class DtoStudentResponse {
    private String firstName;
    private String lastName;
    private LocalDate date;
    @Enumerated
    private GenderEnum gender;
}
