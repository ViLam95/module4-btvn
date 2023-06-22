package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Classes;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClassesService extends IGeneralClassService<Classes> {
    List<Classes> sortByQuantityAsc();

    List<Classes> sortByQuantityDesc();
}
