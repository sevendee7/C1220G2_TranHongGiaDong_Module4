package com.codegym.repository;

import com.codegym.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDiscountRepository extends JpaRepository<Discount, Integer> {

    Page<Discount> findAllByAmountContains(String amount, Pageable pageable);
}
