package com.smoothstack.gcfashion.controller;

import java.time.LocalDate;
import java.util.List;

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
import com.smoothstack.gcfashion.entity.ReportElement;
import com.smoothstack.gcfashion.service.AccountantService;

@RestController
@RequestMapping("/gcfashions")
public class AccountantController {

	@Autowired
	AccountantService acctService;

	@CrossOrigin
	@GetMapping("/report/{reportName}")
	public ResponseEntity<Report> getReport(@PathVariable String reportName,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("startDate") LocalDate startDate,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") LocalDate endDate) {
		return new ResponseEntity<List<ReportElement>>(acctService.getReport(reportName), HttpStatus.OK);
	}

}