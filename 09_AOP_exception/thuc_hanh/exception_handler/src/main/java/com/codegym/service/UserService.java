package com.codegym.service;

import com.codegym.model.User;
import com.codegym.util.DuplicateEmailException;



public interface UserService {
     void save(User user) throws DuplicateEmailException;
}
