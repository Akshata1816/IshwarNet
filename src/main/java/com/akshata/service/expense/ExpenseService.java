package com.akshata.service.expense;

import java.util.Set;

import com.akshata.entity.Expense;

public interface ExpenseService {

	public Expense addExpense(Expense expense); 
	
	public Expense updateExpense(Expense expense);
	
	public Expense getExpense(long e_id);
	
	public Set<Expense> getExpenses();
	
	public void deleteExpense(long e_id);
}
