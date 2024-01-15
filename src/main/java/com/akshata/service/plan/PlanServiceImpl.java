package com.akshata.service.plan;

import java.util.HashSet;
import java.util.Set;

import com.akshata.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshata.entity.Plan;
import com.akshata.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;
	
	@Override
	public Plan addPlan(Plan plan) {
		return this.planRepository.save(plan);
	}

	@Override
	public Plan updatePlan(Plan plan) {
		return this.planRepository.save(plan);
	}

	@Override
	public Set<Plan> getPlans() {
		return new HashSet<>(this.planRepository.findAll());
	}

	@Override
	public Plan getPlan(long planId) {
		return this.planRepository.findById(planId).get();
	}

	@Override
	public void deletePlan(long planId) {
		this.planRepository.deleteById(planId);
		
	}

}
