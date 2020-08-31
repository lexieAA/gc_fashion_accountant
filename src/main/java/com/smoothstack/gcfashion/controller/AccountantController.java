package com.smoothstack.gcfashion.controller;

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
import com.smoothstack.gcfashion.service.ReportService;

@RestController
@RequestMapping("/gcfashions")
public class AccountantController {

	@Autowired
	ReportService reportService;
	
	@CrossOrigin
	@GetMapping("/reports/{report}")
	public ResponseEntity<Report> getReport(@PathVariable String report,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam Optional<LocalDate> startDate,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam Optional<LocalDate> endDate,
			@RequestParam Optional<Boolean> isLiveData) {

		LocalDate start = startDate.orElse(LocalDate.now().with(firstDayOfYear()));
		LocalDate end = endDate.orElse(LocalDate.now());
		Boolean isLive = isLiveData.orElse(true);

		return new ResponseEntity<Report>(reportService.getReport(report, start, end, isLive), HttpStatus.OK);
	}

}