package com.codegym.service;

import com.codegym.model.Register;

import java.util.List;

public interface IRegisterService {
        void save(Register register);
        boolean checkExistEmail(String email);
        boolean checkExistPhoneNumber(String phoneNumber);
        List<Register> findAll();
}
