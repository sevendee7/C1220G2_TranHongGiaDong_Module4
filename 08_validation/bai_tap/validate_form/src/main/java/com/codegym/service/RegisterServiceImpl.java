package com.codegym.service;

import com.codegym.model.Register;
import com.codegym.repository.IRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    IRegisterRepository registerRepository;
    @Override
    public void save(Register register) {
        registerRepository.save(register);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return registerRepository.existsRegisterByEmail(email);
    }

    @Override
    public boolean checkExistPhoneNumber(String phoneNumber) {
        return registerRepository.existsRegisterByPhone(phoneNumber);
    }

    @Override
    public List<Register> findAll() {
        return null;
    }
}
