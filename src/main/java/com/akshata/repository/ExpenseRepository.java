package com.akshata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshata.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
