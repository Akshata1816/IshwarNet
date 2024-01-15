package com.akshata.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String plan_name;
	private Double pin_rate;
	private Double customer_amount;
	private boolean status = true;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public Double getPin_rate() {
		return pin_rate;
	}
	public void setPin_rate(Double pin_rate) {
		this.pin_rate = pin_rate;
	}
	public Double getCustomer_amount() {
		return customer_amount;
	}
	public void setCustomer_amount(Double customer_amount) {
		this.customer_amount = customer_amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
