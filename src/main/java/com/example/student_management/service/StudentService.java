package com.example.student_management.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Ajouter ou modifier un étudiant
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // Supprimer un étudiant à partir de son identifiant
    public boolean delete(int id) {
        Optional<Student> studentOptional =
                studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        }

        return false;
    }

    // Récupérer tous les étudiants
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // Compter le nombre total d'étudiants
    public long countStudents() {
        return studentRepository.count();
    }

    // Compter les étudiants par année de naissance
    public Collection<?> findNbrStudentByYear() {
        return studentRepository.findNbrStudentByYear();
    }
}
