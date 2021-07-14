package com.codegym.service.impl;

import com.codegym.model.Classes;
import com.codegym.repository.IClassesRepository;
import com.codegym.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements IClassesService {
    @Autowired
    private IClassesRepository classesRepository;

    @Override
    public List<Classes> findAllClasses() {
        return classesRepository.findAll();
    }
}
