package com.codegym.repository;

import com.codegym.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterRepository extends JpaRepository<Register, Integer> {

    boolean existsRegisterByEmail(String email);

    boolean existsRegisterByPhone(String phoneNumber);
}

