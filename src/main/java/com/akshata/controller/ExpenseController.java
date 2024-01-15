package com.akshata.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshata.entity.Expense;
import com.akshata.service.expense.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@PostMapping("/add")
	public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
		Expense expense2 = this.expenseService.addExpense(expense);
		return ResponseEntity.ok(expense2);
	}
	
	@PutMapping("/update")
	public Expense updatExpense(@RequestBody Expense expense) {
		return this.expenseService.updateExpense(expense);
	}
	
	@GetMapping("/{id}")
	public Expense getExpense(@PathVariable long id) {
		return this.expenseService.getExpense(id);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Set<Expense>> gerExpenses() {
		return ResponseEntity.ok(this.expenseService.getExpenses());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteExpense(@PathVariable long e_id) {
		this.expenseService.deleteExpense(e_id);
	}
	
}
