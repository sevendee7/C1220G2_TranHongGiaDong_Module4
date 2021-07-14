package com.codegym.service.employee.impl;

import com.codegym.model.entity.EducationBackground;
import com.codegym.repository.employee.IEducationRepository;
import com.codegym.service.employee.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService {

    @Autowired
    private IEducationRepository educationRepository;

    @Override
    public List<EducationBackground> findAll() {
        return educationRepository.findAll();
    }
}
