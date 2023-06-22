package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Classes;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClassesService implements IClassesService{
    @Autowired
    private IClassRepository classRepository;
    @Override
    public Iterable<Classes> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public void save(Classes classes) {
        classRepository.save(classes);
    }

    @Override
    public void remove(Long id) {
        classRepository.deleteById(id);
    }

    @Override
    public List<Classes> sortByQuantityAsc() {
        return classRepository.findAllByOrderByQuantityAsc();
    }

    @Override
    public List<Classes> sortByQuantityDesc() {
        return classRepository.findAllByOrderByQuantityDesc();
    }
}
