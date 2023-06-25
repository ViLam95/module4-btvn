package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Classes;
import com.example.studentmanagement.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentService extends IGeneralService<Student> {
    Page<Student> searchByName(String name, Pageable pageable);
    List<Student> findAllByOrderByPointAsc();
    List<Student> findAllByOrderByPointDesc();
    List<Student> viewStudent(Classes classes);
    List<Student> findAllByOrderByAgeAsc();
    List<Student> findAllByOrderByAgeDesc();
    Page<Student> findAll(Pageable pageable);
    List<Student> getStudentsByGender(String gender);
    List<Student> findByAgeBetween(int minAge, int maxAge);

}
