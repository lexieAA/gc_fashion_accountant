package com.smoothstack.gcfashion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.gcfashion.entity.User;
import com.smoothstack.gcfashion.service.AccountantService;

@RestController
@RequestMapping("/gcfashions")
public class AccountantController {
	
	@Autowired
	AccountantService acctService;	
	
	@GetMapping("/accountant")
	public ResponseEntity<List<User>> findAllManagers() {		
		List<User> managers = acctService.findAllManagers();
		return managers != null && managers.size() > 0 ?
				new ResponseEntity<List<User>>(managers, HttpStatus.OK) :
				ResponseEntity.notFound().build();
	}
	
	@GetMapping("accountant/reports/taxes")
	public ResponseEntity<Object> getTaxesReport() {
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("accountant/reports/sales")
	public ResponseEntity<Object> getSalesReport() {
		return ResponseEntity.notFound().build();
	}
}