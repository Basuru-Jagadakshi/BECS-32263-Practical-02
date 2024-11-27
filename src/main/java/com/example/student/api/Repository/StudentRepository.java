package com.example.student.api.Repository;

import com.example.student.api.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByYearOfEnrollment(String yearOfEnrollment);

    @Query("SELECT s.department FROM Student s WHERE s.id = :id")
    String findDepartmentById(@Param("id") long id);

    void deleteByYearOfEnrollment(String yearOfEnrollment);
}
