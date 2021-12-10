package com.skni.workshopspring3.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String firstName;

    String lastName;

    LocalDate date;
    @Enumerated(EnumType.STRING)
    GenderEnum gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",nullable = false)
    Course course;

}
