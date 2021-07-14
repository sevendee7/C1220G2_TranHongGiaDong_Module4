package com.codegym.service.employee;

import com.codegym.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    void save(User user);

    void login(String username, String password);

    User findByUsername(String username);

    User findById(Integer id);
}
