package com.skni.workshopspring3.Controller;

import com.skni.workshopspring3.Dto.DtoStudentRequest;
import com.skni.workshopspring3.Dto.DtoStudentResponse;
import com.skni.workshopspring3.Entity.CourseTypeEnum;
import com.skni.workshopspring3.Entity.GenderEnum;
import com.skni.workshopspring3.Entity.Student;
import com.skni.workshopspring3.Repository.CourseRepository;
import com.skni.workshopspring3.Repository.StudentRepository;
import com.skni.workshopspring3.Service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class StudentController {
    StudentService studentService;
    ModelMapper modelMapper;
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody DtoStudentRequest dtoStudentRequest){
        Student student = modelMapper.map(dtoStudentRequest,Student.class);
        studentService.addStudent(student.getFirstName(),student.getLastName(),student.getDate(),student.getGender(),student.getCourse());

    }
    @GetMapping("/getAllStudents")
    public List<DtoStudentResponse> getStudent(){
        return studentService.getAllStudents();
    }
    @GetMapping("/getStudentByGenderAndByCourseType/{gender}/{type}")
    public DtoStudentResponse getStudentByGenderAndByCourseType(@PathVariable GenderEnum gender,@PathVariable CourseTypeEnum type){
        return studentService.getStudentByGenderAndByCourseType(gender,type);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudentById(id);
    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id,@RequestBody Student student){
        if(studentService.updateStudent(id, student)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
