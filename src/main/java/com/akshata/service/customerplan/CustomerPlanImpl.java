package com.akshata.service.customerplan;

import com.akshata.entity.Customer;
import com.akshata.entity.CustomerPlan;
import com.akshata.entity.Plan;
import com.akshata.entity.PredefinedMaster;
import com.akshata.repository.CustomerPlanRepository;
import com.akshata.service.customer.CustomerService;
import com.akshata.service.plan.PlanService;
import com.akshata.service.predefined.PredefinedMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerPlanImpl implements CustomerPlanService {

    @Autowired
    private CustomerPlanRepository customerPlanRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PlanService planService;

    @Autowired
    private PredefinedMasterService predefinedMasterService;


    @Override
    public CustomerPlan saveCustomerPlan(CustomerPlan customerPlan) {

        Customer customer = customerService.getCustomer(customerPlan.getCustomer().getCustomer_id());
        customerPlan.setCustomer(customer);

        Plan plan = planService.getPlan(customerPlan.getPlan().getId());
        customerPlan.setPlan(plan);

        if(customerPlan.getDiscount() != null){
            Double afterDiscount = plan.getCustomer_amount() - customerPlan.getDiscount();
            customerPlan.setTotalAmount(afterDiscount);
            customerPlan.setRemainingAmount(afterDiscount);
        }
        else {
            customerPlan.setTotalAmount(plan.getCustomer_amount());
            customerPlan.setRemainingAmount(plan.getCustomer_amount());
        }

        Date startDate = customerPlan.getStartDate();

        if(customerPlan.getPackageType() != null && !customerPlan.getPackageType().isEmpty()){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            if(customer.getPackageType().getCode().equals("MONTHLY")){
                calendar.add(Calendar.DAY_OF_MONTH, 29);
            }else if(customer.getPackageType().getCode().equals("QUARTERLY")){
                calendar.add(Calendar.DAY_OF_MONTH, 89);
            }else if(customer.getPackageType().getCode().equals("HALF-YEARLY")){
                calendar.add(Calendar.DAY_OF_MONTH, 179);
            }else if(customer.getPackageType().getCode().equals("YEARLY")){
                calendar.add(Calendar.DAY_OF_YEAR, 359);
            }

//            if(customerPlan.getPackageType().equals("MONTHLY")){
//                calendar.add(Calendar.DAY_OF_MONTH, 29);
//            }else if(customerPlan.getPackageType().equals("QUARTERLY")){
//                calendar.add(Calendar.DAY_OF_MONTH, 89);
//            }else if(customerPlan.getPackageType().equals("HALF-YEARLY")){
//                calendar.add(Calendar.DAY_OF_MONTH, 179);
//            }else if(customerPlan.getPackageType().equals("YEARLY")){
//                calendar.add(Calendar.DAY_OF_YEAR, 359);
//            }else {
//                // Handle unknown package type
//                System.out.println("Invalid package type");
//            }

            customerPlan.setEndDate(calendar.getTime());
        }

        PredefinedMaster predefinedMaster = predefinedMasterService.getPredefinedByCodeAndName("ACTIVE","STATUS");
        customerPlan.setPredefinedMaster(predefinedMaster);

        customerPlan = this.customerPlanRepository.save(customerPlan);

        return customerPlan;
    }

    @Override
    public Set<CustomerPlan> getCustomerPlanList() {
        return new HashSet<>(this.customerPlanRepository.findAll());
    }

    @Override
    public CustomerPlan updateCustomerPlan(CustomerPlan customerPlan) {
        CustomerPlan oldCustomerPlan = getCustomerPlanById(customerPlan.getCustomerPlanId());
        Double total = 0.0;
        if (customerPlan.getCurrentPaidAmount() != null)
        {
            String oldPaidAmount = oldCustomerPlan.getPaidAmount();
            String newPaidAmount = customerPlan.getCurrentPaidAmount().toString();

            if (oldPaidAmount != null && !oldPaidAmount.isEmpty()) {
                // If oldPaidAmount is not empty, append a comma before adding the new amount
                oldCustomerPlan.setPaidAmount(oldPaidAmount + "," + newPaidAmount);
            } else {
                // If oldPaidAmount is empty, just set the new amount
                oldCustomerPlan.setPaidAmount(newPaidAmount);
            }

            total = oldCustomerPlan.getRemainingAmount() - customerPlan.getCurrentPaidAmount();
            oldCustomerPlan.setRemainingAmount(total);
        }

        customerPlan = this.customerPlanRepository.save(oldCustomerPlan);
        return customerPlan;
    }

    @Override
    public CustomerPlan getCustomerPlanById(long customerPlanId) {
        return this.customerPlanRepository.findById(customerPlanId).get();
    }


}
