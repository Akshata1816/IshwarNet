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
	private long pin_rate;
	private long customer_amount;
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
	public long getPin_rate() {
		return pin_rate;
	}
	public void setPin_rate(long pin_rate) {
		this.pin_rate = pin_rate;
	}
	public long getCustomer_amount() {
		return customer_amount;
	}
	public void setCustomer_amount(long customer_amount) {
		this.customer_amount = customer_amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
