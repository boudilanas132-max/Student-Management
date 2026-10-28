package com.example.student_management.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Ajouter un étudiant
    @PostMapping("/save")
    public ResponseEntity<Student> save(
            @RequestBody Student student) {

        Student savedStudent = studentService.save(student);

        return new ResponseEntity<>(
                savedStudent, HttpStatus.CREATED);
    }

    // Supprimer un étudiant
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable int id) {

        boolean deleted = studentService.delete(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    // Afficher tous les étudiants
    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    // Compter les étudiants
    @GetMapping("/count")
    public ResponseEntity<Long> countStudent() {
        return ResponseEntity.ok(
                studentService.countStudents());
    }

    // Statistiques par année de naissance
    @GetMapping("/byYear")
    public ResponseEntity<Collection<?>> findByYear() {
        return ResponseEntity.ok(
                studentService.findNbrStudentByYear());
    }
}
