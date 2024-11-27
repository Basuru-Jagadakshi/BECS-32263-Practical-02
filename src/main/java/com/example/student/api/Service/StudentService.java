package com.example.student.api.Service;

import com.example.student.api.Model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(long id);
    Student updateStudent(Student student, long id);
    void deleteStudent(long id);

    List<Student> getStudentsByYear(String yearOfEnrollment);
    String getDepartmentById(long id);
    void deleteStudentsByYear(String yearOfEnrollment);
}
