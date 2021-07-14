package com.codegym.repository.employee;

import com.codegym.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

//    @Query("SELECT u FROM User u WHERE u.username = ?1")
//    User findByUsername(String email);
//
//    @Query("SELECT u.id FROM User u WHERE u.username = ?1")
//    Integer getUserIdByEmail(String email);
//
//    Boolean existsUsersByEmail(String email);

    User findByUsername(String username);

    User findById(long id);


}
