package com.akshata.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshata.entity.Expense;
import com.akshata.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Override
	public Expense addExpense(Expense expense) {
		return this.expenseRepository.save(expense);
	}

	@Override
	public Expense updateExpense(Expense expense) {
		return this.expenseRepository.save(expense);
	}

	@Override
	public Expense getExpense(long e_id) {
		return this.expenseRepository.findById(e_id).get();
	}

	@Override
	public Set<Expense> getExpenses() {
		return new HashSet<>(this.expenseRepository.findAll());
	}

	@Override
	public void deleteExpense(long e_id) {
		this.expenseRepository.deleteById(e_id);
	}
	
	

}
