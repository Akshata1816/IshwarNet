package com.akshata.service.plan;

import java.util.Set;

import com.akshata.entity.Plan;

public interface PlanService {

	public Plan addPlan(Plan plan);
	
	public Plan updatePlan(Plan plan);
	
	public Set<Plan> getPlans();
	
	public Plan getPlan(long planId);
	
	public void deletePlan(long planId);
}
