package com.codegym.service.employee.impl;

import com.codegym.model.entity.Department;
import com.codegym.repository.employee.IDepartmentRepository;
import com.codegym.service.employee.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

}
