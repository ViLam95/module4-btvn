package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Classes;
import com.example.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentService extends IGeneralService<Student> {
    @Query("select s from Student s where LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Student> searchByName(@Param("name") String name);
    List<Student> findAllByOrderByPointAsc();
    List<Student> findAllByOrderByPointDesc();
    List<Student> viewStudent(Classes classes);
    List<Student> findAllByOrderByAgeAsc();
    List<Student> findAllByOrderByAgeDesc();

}
