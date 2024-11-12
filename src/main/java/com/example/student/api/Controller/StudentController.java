package com.example.student.api.Controller;

import com.example.student.api.Model.Student;
import com.example.student.api.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id){
        return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id){
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student record is deleted ", HttpStatus.OK);
    }
}
