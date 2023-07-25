package com.akshata.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "expense")
public class Expense extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long e_id;
	private String expense_name;
	private long amount;
	
	@JsonFormat(pattern = "YYYY-MM-DD")
	private Date expenseDate;
	
	public long getE_id() {
		return e_id;
	}
	public void setE_id(long e_id) {
		this.e_id = e_id;
	}
	public String getExpense_name() {
		return expense_name;
	}
	public void setExpense_name(String expense_name) {
		this.expense_name = expense_name;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	
	
}
