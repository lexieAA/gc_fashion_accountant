package com.smoothstack.gcfashion.controller;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/report/{reportName}")
	public ResponseEntity<Report> getReport(@PathVariable String reportName,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam Optional<LocalDate> startDate,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam Optional<LocalDate> endDate) {

		return new ResponseEntity<Report>(acctService.getReport(reportName,
				startDate.orElse(LocalDate.now().with(firstDayOfYear())), endDate.orElse(LocalDate.now())),
				HttpStatus.OK);
	}
	
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

}