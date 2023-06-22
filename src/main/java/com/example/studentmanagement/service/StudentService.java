package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Classes;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> searchByName(String name) {
        return studentRepository.searchByName(name);
    }

    @Override
    public List<Student> findAllByOrderByPointAsc() {
        return studentRepository.findAllByOrderByPointAsc();
    }

    @Override
    public List<Student> findAllByOrderByPointDesc() {
        return studentRepository.findAllByOrderByPointDesc();
    }

    @Override
    public List<Student> viewStudent(Classes classes) {
        return studentRepository.findAllByClasses(classes);
    }

    @Override
    public List<Student> findAllByOrderByAgeAsc() {
        return studentRepository.findAllByOrderByAgeAsc();
    }

    @Override
    public List<Student> findAllByOrderByAgeDesc() {
        return studentRepository.findAllByOrderByAgeDesc();
    }


}
