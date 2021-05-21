package com.codegym.repository;

import com.codegym.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

    @Query("SELECT u.id FROM User u WHERE u.email = ?1")
    Integer getUserIdByEmail(String email);

    Boolean existsUsersByEmail(String email);
}
