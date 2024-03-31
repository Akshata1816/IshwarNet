package com.akshata.repository;

import com.akshata.entity.CustomerPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerPlanRepository extends JpaRepository<CustomerPlan, Long> {

    public List<CustomerPlan> findByStatusIdAndCustomerId(Long statusId, Long customerId);

    public List<CustomerPlan> findByCustomerIdOrderByCustomerPlanIdDesc(Long customerId);
}
