package com.akshata.service.customerplan;

import com.akshata.entity.Customer;
import com.akshata.entity.CustomerPlan;

import java.util.Set;

public interface CustomerPlanService {

    public CustomerPlan saveCustomerPlan(CustomerPlan customerPlan);

    Set<CustomerPlan> getCustomerPlanList();
}
