package com.akshata.controller;

import com.akshata.entity.Customer;
import com.akshata.entity.CustomerPlan;
import com.akshata.service.customerplan.CustomerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/getList/status/{customerId}")
    public ResponseEntity<List<CustomerPlan>> getCustomerPlanStatusList(@PathVariable Long customerId) {
        return ResponseEntity.ok(this.customerPlanService.getCustomerPlanByStatus(customerId));
    }

    @GetMapping("/active/{customerId}")
    public ResponseEntity<CustomerPlan> getCustomerPlanStatusByCustId(@PathVariable Long customerId) throws Exception {
        return ResponseEntity.ok(this.customerPlanService.getCustomerPlanByCustId(customerId));
    }

    @GetMapping("/geCustomerList/{customerId}")
    public ResponseEntity<List<CustomerPlan>> getCustomerPlanCustomerList(@PathVariable Long customerId) {
        return ResponseEntity.ok(this.customerPlanService.getCustomerPlanByCustomerId(customerId));
    }

}
