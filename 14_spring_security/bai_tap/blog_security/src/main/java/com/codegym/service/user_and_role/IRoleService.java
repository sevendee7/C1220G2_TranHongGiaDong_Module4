package com.codegym.service.user_and_role;

import com.codegym.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleService {
    Role findByName(String name);
    List<Role> findAll();
    Role findById(long id);
}
