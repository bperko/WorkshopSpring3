package com.skni.workshopspring3.Service;

import com.skni.workshopspring3.Dto.DtoStudentResponse;
import com.skni.workshopspring3.Entity.Course;
import com.skni.workshopspring3.Entity.CourseTypeEnum;
import com.skni.workshopspring3.Entity.GenderEnum;
import com.skni.workshopspring3.Entity.Student;
import com.skni.workshopspring3.Repository.StudentRepository;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    StudentRepository studentRepository;
    ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository,ModelMapper modelMapper){
        this.studentRepository = studentRepository;
        this.modelMapper=modelMapper;
    }
    public List<DtoStudentResponse> findAllByLastName(String lastName){
        List<Student> list = studentRepository.findAllByLastName(lastName);
        List<DtoStudentResponse> resultList = list.stream().map(x->modelMapper.map(x,DtoStudentResponse.class)).collect(Collectors.toList());
        return resultList;
    }
    public Student addStudent(String firstName, String lastName, LocalDate date, GenderEnum gender, Course course){
    Student student = Student.builder().firstName(firstName).lastName(lastName).date(date).gender(gender).course(course).build();
    studentRepository.save(student);
    return student;
    }
    public DtoStudentResponse getStudentByGenderAndByCourseType(GenderEnum gender, CourseTypeEnum type){
        Student student =  studentRepository.getStudentByGenderAndCourse_CourseType(gender,type);
        DtoStudentResponse dtoStudentResponse = modelMapper.map(student,DtoStudentResponse.class);
        return dtoStudentResponse;
    }
    public List<DtoStudentResponse> getAllStudents(){
        List<Student> list =studentRepository.findAll();
        List<DtoStudentResponse> resultList = list.stream().map(x->modelMapper.map(x,DtoStudentResponse.class)).collect(Collectors.toList());
        return resultList;
    }
    public String deleteStudentById(Integer id){
        studentRepository.deleteById(id);
        return "Student o id "+id;
    }
    public List<DtoStudentResponse> findStudentWhereFirstNameStartsWithA(){
        List<Student> students = studentRepository.findStudentWhereFirstNameStartsWithA();
        List<DtoStudentResponse> resultList = students.stream().map(x->modelMapper.map(x,DtoStudentResponse.class)).collect(Collectors.toList());
        return resultList;
    }
    public DtoStudentResponse findStudentById(int id){
        return modelMapper.map(studentRepository.findById(id),DtoStudentResponse.class);
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public boolean updateStudent(int id,Student student){
        Optional<Student> newStudent = studentRepository.findById(id);
        if(newStudent.isPresent()) {
            Student studentFromRepo = newStudent.get();
            if (student.getFirstName() != null) {
                studentFromRepo.setFirstName(student.getFirstName());
            }
            if (student.getLastName() != null) {
                studentFromRepo.setLastName(student.getLastName());
            }
            studentRepository.save(studentFromRepo);
            return true;
        }
        return false;
    }
}
