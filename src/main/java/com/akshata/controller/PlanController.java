package com.akshata.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshata.entity.Plan;
import com.akshata.service.plan.PlanService;

@RestController
@CrossOrigin("*")
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@PostMapping("/add")
	public ResponseEntity<Plan> addPlan(@RequestBody Plan plan) {
		Plan plan2 = this.planService.addPlan(plan);
		return ResponseEntity.ok(plan2);
	}
	
	@PutMapping("/update")
	public Plan updatePlan(@RequestBody Plan plan) {
		return this.planService.updatePlan(plan);
	}
	
	@GetMapping("/{id}")
	public Plan getPlan(@PathVariable long id) {
		return this.planService.getPlan(id);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Set<Plan>> getPlans() {
		return ResponseEntity.ok(this.planService.getPlans());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePlan(@PathVariable long id) {
		this.planService.deletePlan(id);
	}
}
