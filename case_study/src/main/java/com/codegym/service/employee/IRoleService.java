package com.codegym.service.employee;

import com.codegym.model.entity.Role;

import java.util.List;

public interface IRoleService {
    Role findByName(String name);
    List<Role> findAll();
    Role findById(Integer id);
}
