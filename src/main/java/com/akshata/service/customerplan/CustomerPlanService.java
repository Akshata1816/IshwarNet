package com.akshata.service.customerplan;

import com.akshata.entity.Customer;
import com.akshata.entity.CustomerPlan;
import com.akshata.entity.Plan;

import java.util.List;
import java.util.Set;

public interface CustomerPlanService {

    public CustomerPlan saveCustomerPlan(CustomerPlan customerPlan);

    Set<CustomerPlan> getCustomerPlanList();

    public CustomerPlan updateCustomerPlan(CustomerPlan customerPlan);

    public CustomerPlan getCustomerPlanById(long customerPlanId);

    List<CustomerPlan> getCustomerPlanByStatus(Long customerId);

    CustomerPlan getCustomerPlanByCustId(Long customerId) throws Exception;

    List<CustomerPlan> getCustomerPlanByCustomerId(Long customerId);
}
