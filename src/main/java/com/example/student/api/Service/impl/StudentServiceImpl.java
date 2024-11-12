package com.example.student.api.Service.impl;

import com.example.student.api.Model.Student;
import com.example.student.api.Repository.StudentRepository;
import com.example.student.api.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentById(long id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            return student.get();
        }
        else {
            throw new RuntimeException();
        }
    }

    public Student updateStudent(Student student, long id){
        Student existingStudents = studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingStudents.setFirstName(student.getFirstName());
        existingStudents.setLastName(student.getLastName());
        existingStudents.setEmail(student.getEmail());

        studentRepository.save(student);
        return existingStudents;
    }

    public void deleteStudent(long id){
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        studentRepository.deleteById(id);
    }
}
