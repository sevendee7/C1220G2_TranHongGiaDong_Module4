package com.codegym.repository.employee;

import com.codegym.model.entity.EducationBackground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<EducationBackground, Integer> {
}
