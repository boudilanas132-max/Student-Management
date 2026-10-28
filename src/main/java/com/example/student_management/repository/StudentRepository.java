package com.example.student_management.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.student_management.entity.Student;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {

    @Query("SELECT YEAR(s.dateNaissance), COUNT(s) "
         + "FROM Student s "
         + "GROUP BY YEAR(s.dateNaissance)")
    Collection<Object[]> findNbrStudentByYear();
}
