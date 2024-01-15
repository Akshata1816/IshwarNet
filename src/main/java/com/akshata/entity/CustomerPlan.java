package com.akshata.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CustomerPlan extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerPlanId;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "customerId", insertable = false, updatable = false)
    private Long customerId;

    @ManyToOne(targetEntity = Plan.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "planId")
    private Plan plan;

    @Column(name = "planId", insertable = false, updatable = false)
    private Long planId;

    private Date startDate;

    private Date endDate;

    private String comment;

    private Double totalAmount;

    private Double Discount;

    private Double remainingAmount;

    private String packageType;

    @ManyToOne(targetEntity = PredefinedMaster.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "predefinedId")
    private PredefinedMaster predefinedMaster;

    @Column(name = "predefinedId", insertable = false, updatable = false)
    private Long predefinedId;

    public PredefinedMaster getPredefinedMaster() {
        return predefinedMaster;
    }

    public void setPredefinedMaster(PredefinedMaster predefinedMaster) {
        this.predefinedMaster = predefinedMaster;
    }

    public Long getPredefinedId() {
        return predefinedId;
    }

    public void setPredefinedId(Long predefinedId) {
        this.predefinedId = predefinedId;
    }

    public long getCustomerPlanId() {
        return customerPlanId;
    }

    public void setCustomerPlanId(long customerPlanId) {
        this.customerPlanId = customerPlanId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    public Double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
}
