package com.codegym.service.employee;

import com.codegym.model.entity.EducationBackground;

import java.util.List;

public interface IEducationService {

    List<EducationBackground> findAll();
}
