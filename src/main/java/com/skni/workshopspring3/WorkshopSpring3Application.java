package com.skni.workshopspring3;

import java.time.LocalDate;

import com.skni.workshopspring3.Entity.Course;
import com.skni.workshopspring3.Entity.CourseTypeEnum;
import com.skni.workshopspring3.Entity.GenderEnum;
import com.skni.workshopspring3.Entity.Student;
import com.skni.workshopspring3.Service.CourseService;
import com.skni.workshopspring3.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkshopSpring3Application {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopSpring3Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	CommandLineRunner init(CourseService courseService, StudentService studentService) {
		return (args) -> {
			Course course = courseService.addCourse("Informatyka", 3, "SGH", CourseTypeEnum.INZYNIER);

			Student studentMale1 = studentService.addStudent(
					"Adam",
					"Nowak",
					LocalDate.of(1996, 05,10),
					GenderEnum.MALE,
					course
			);

			Student studentFemale = studentService.addStudent(
					"Anna",
					"Kowalska",
					LocalDate.of(1993, 10,22),
					GenderEnum.FEMALE,
					course
			);
			Student studentFemale2 = studentService.addStudent(
					"Anna",
					"Kapusta",
					LocalDate.of(1993, 10,22),
					GenderEnum.FEMALE,
					course
			);

			//System.out.println(studentMale1);
			//System.out.println(studentFemale);

			//System.out.println(studentService.findAllByLastName("Nowak"));

			//System.out.println(studentService.getStudentByGenderAndByCourseType(GenderEnum.MALE, CourseTypeEnum.INZYNIER));
			//System.out.println(studentService.getStudentByGenderAndByCourseType(GenderEnum.FEMALE, CourseTypeEnum.LICENCJAT));

			//System.out.println(studentService.getAllStudents());
			//System.out.println(studentService.deleteStudentById(studentMale1.getId()));
			//System.out.println(studentService.findStudentWhereFirstNameStartsWithA());

		};
	}
}
