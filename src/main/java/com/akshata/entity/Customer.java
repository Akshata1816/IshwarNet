package com.akshata.entity;

import javax.persistence.*;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "customer")
public class Customer extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customer_id;
	private String customer_name;
	private String username;
	private Long mob_number;
	private Long alt_mob_number;
	private String address;
	private String city;
	private String pincode;
	private boolean status = true;

	@ManyToOne(targetEntity = PredefinedMaster.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "packageTypeId")
	private PredefinedMaster packageType;

	@Column(name = "packageTypeId", insertable = false, updatable = false)
	private Long packageTypeId;

	public PredefinedMaster getPackageType() {
		return packageType;
	}

	public void setPackageType(PredefinedMaster packageType) {
		this.packageType = packageType;
	}

	public Long getPackageTypeId() {
		return packageTypeId;
	}

	public void setPackageTypeId(Long packageTypeId) {
		this.packageTypeId = packageTypeId;
	}

	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getMob_number() {
		return mob_number;
	}
	public void setMob_number(Long mob_number) {
		this.mob_number = mob_number;
	}
	public Long getAlt_mob_number() {
		return alt_mob_number;
	}
	public void setAlt_mob_number(Long alt_mob_number) {
		this.alt_mob_number = alt_mob_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
}
