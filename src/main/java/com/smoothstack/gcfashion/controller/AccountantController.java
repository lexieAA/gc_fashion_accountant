package com.smoothstack.gcfashion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.gcfashion.entity.Report;
import com.smoothstack.gcfashion.entity.User;
import com.smoothstack.gcfashion.service.AccountantService;

@RestController
@RequestMapping("/gcfashions")
public class AccountantController {

	@Autowired
	AccountantService acctService;

	@CrossOrigin
	@GetMapping("/accountant")
	public ResponseEntity<List<User>> findAllManagers() {
		List<User> managers = acctService.findAllManagers();
		return managers != null && managers.size() > 0 ? new ResponseEntity<List<User>>(managers, HttpStatus.OK)
				: ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@GetMapping("/accountant/{userId}")
	public ResponseEntity<User> findManagerById(@PathVariable long userId) {
		User manager = acctService.findManagerById(userId);
		return manager != null ? new ResponseEntity<User>(manager, HttpStatus.OK) : ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@GetMapping("accountant/reports/sales")
	public ResponseEntity<Report> getSalesReport() {
		return new ResponseEntity<Report>(acctService.getSalesReport(), HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("accountant/reports/taxes")
	public ResponseEntity<Report> getTaxReport() {
		return new ResponseEntity<Report>(acctService.getTaxReport(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("accountant/reports/salesbycat")
	public ResponseEntity<Report> getSalesByCat() {
		return new ResponseEntity<Report>(acctService.getSalesByCat(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("accountant/reports/totalsales")
	public ResponseEntity<Report> getTotalSales() {
		return new ResponseEntity<Report>(acctService.getTotalSales(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("accountant/reports/totaltaxes")
	public ResponseEntity<Report> getTotalTaxes() {
		return new ResponseEntity<Report>(acctService.getTotalTaxes(), HttpStatus.OK);
	}
}