package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Classes;
import com.example.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Student> searchByName(@Param("name") String name);
    List<Student> findAllByOrderByPointAsc();
    List<Student> findAllByOrderByPointDesc();
    List<Student> findAllByClasses(Classes classes);
    List<Student> findAllByOrderByAgeAsc();
    List<Student> findAllByOrderByAgeDesc();
}
