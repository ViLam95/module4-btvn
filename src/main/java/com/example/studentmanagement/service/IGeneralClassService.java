package com.example.studentmanagement.service;

import java.util.Optional;

public interface IGeneralClassService<K> {
    Iterable<K> findAll();
    Optional<K> findById(Long id);
    void save(K k);
    void remove(Long id);
}
