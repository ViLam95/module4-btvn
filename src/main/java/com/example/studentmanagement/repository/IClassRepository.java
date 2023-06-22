package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Classes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClassRepository extends PagingAndSortingRepository<Classes, Long> {
    List<Classes> findAllByOrderByQuantityAsc();

    List<Classes> findAllByOrderByQuantityDesc();
}
