package com.skni.workshopspring3.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    Integer id;
    String courseName;
    int year;
    String universityName;
    @Enumerated(EnumType.STRING)
    CourseTypeEnum courseType;

}
