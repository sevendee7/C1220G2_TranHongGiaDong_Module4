package com.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {

    Page<T> findAll(Pageable pageable) throws Exception;

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
