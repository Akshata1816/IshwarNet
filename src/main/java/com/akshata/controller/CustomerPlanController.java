package com.akshata.controller;

import com.akshata.entity.Customer;
import com.akshata.entity.CustomerPlan;
import com.akshata.service.customerplan.CustomerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer-plan")
public class CustomerPlanController {

    @Autowired
    private CustomerPlanService customerPlanService;

    @PostMapping("/save")
    public ResponseEntity<CustomerPlan> saveCustomerPlan(@RequestBody CustomerPlan customerPlan) {
        return ResponseEntity.ok(this.customerPlanService.saveCustomerPlan(customerPlan));
    }

    @GetMapping("/getList")
    public ResponseEntity<Set<CustomerPlan>> getCustomerPlanList() {
        return ResponseEntity.ok(this.customerPlanService.getCustomerPlanList());
    }

    @PutMapping("/update")
    public CustomerPlan updateCustomer(@RequestBody CustomerPlan customerPlan) {
        return this.customerPlanService.updateCustomerPlan(customerPlan);
    }

    @GetMapping("/{id}")
    public CustomerPlan getCustomerPlanById(@PathVariable long customerPlanId) {
        return this.customerPlanService.getCustomerPlanById(customerPlanId);
    }


}
