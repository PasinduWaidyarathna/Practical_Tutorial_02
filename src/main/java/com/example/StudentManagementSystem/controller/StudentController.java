package com.example.StudentManagementSystem.controller;
import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.service.StudentService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;

import java.util.List; 
   
@RestController 
@RequestMapping("/api/students") 
@CrossOrigin(origins = "*")
public class StudentController { 
    @GetMapping("/")
    public String home() {
        return "index"; // This looks for index.html in the templates folder
    }     
    @Autowired
    private StudentService studentService; 
    @PostMapping 
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new 
        ResponseEntity<Student>(studentService.saveStudent(student), 
            HttpStatus.CREATED); 
    } 
    //GetAll Rest Api 
    @GetMapping 
    public List<Student> getAllStudent(){ 
        return studentService.getAllStudent(); 
    } 
    //Get by Id Rest Api 
    @GetMapping("{id}") 
    //localhost:8080/api/students/1 
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long StudentID){ 
        return new 
        ResponseEntity<Student>(studentService.getStudentById(StudentID),HttpStatus.OK);
    } 
    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student Student){ 
        return new 
        ResponseEntity<Student>(studentService.updateStudent(Student,id),HttpStatus.OK); 
    } 
    //Delete Rest Api 
    @DeleteMapping("{id}") 
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){ 
        //delete Student from db 
        studentService.deleteStudent(id); 
        return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
    } 
}
