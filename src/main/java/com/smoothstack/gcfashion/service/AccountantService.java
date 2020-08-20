package com.smoothstack.gcfashion.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.smoothstack.gcfashion.dao.UserDAO;
import com.smoothstack.gcfashion.entity.DummyData;
import com.smoothstack.gcfashion.entity.Report;
import com.smoothstack.gcfashion.entity.ReportElement;
import com.smoothstack.gcfashion.entity.User;

public class AccountantService {

	@Autowired
	DummyData d;

	@Autowired
	UserDAO uDAO;

	public List<User> findAllManagers() {
		return uDAO.findAll().stream().filter(user -> "management".equals(user.getRole())).collect(Collectors.toList());
	}
	
	public User findManagerById(Long userId) {
		User user = uDAO.findById(userId).orElse(null);
		return "management".equals(user.getRole()) ? user : null;
	}
	
	public Report getReport(String reportName, LocalDate startDate, LocalDate endDate) {
		System.out.println(reportName +", "+startDate+", "+endDate);
		switch(reportName.toLowerCase()) {
		  case "salesbyloc":
			  return getSalesByLoc();
		  case "taxesbyloc":
			  return getSalesByLoc();
		  case "salesbycat":
			  return getSalesByLoc();
		  case "totalsales":
			  return getSalesByLoc();
		  case "totaltaxes":
			  return getSalesByLoc();
		  case "avgsales":
			  return getSalesByLoc();
		  case "salesbytransaction":
			  return getSalesByLoc();
		  case "volbyloc":
			  return getSalesByLoc();
		  default:
			  return getBlankReport();		    
		}
	}

	public Report getSalesByLoc() {
		//return new Report("Sales by Location", uDAO.getSalesReport().stream().map(r -> new ReportElement((String)r[0],(BigDecimal)r[1])).collect(Collectors.toList()));
		return d.getFakeSalesByLoc();
	}

	public Report getTaxReport() {
		//return new Report("Taxes by Location", uDAO.getTaxReport().stream().map(r -> new ReportElement((String)r[0],(BigDecimal)r[1])).collect(Collectors.toList()));
		return d.getFakeTaxes();
	}
	
	public Report getSalesByCat() {
		//return new Report("Taxes by Location", uDAO.getSalesByCatReport().stream().map(r -> new ReportElement((String)r[0],(BigDecimal)r[1])).collect(Collectors.toList()));
		return d.getFakeSalesByCat();		
	}
	
	public Report getTotalSales() {
		return d.getFakeTotalSales();		
	}
	
	public Report getTotalTaxes() {
		return d.getFakeTotalTaxes();		
	}
	
	public Report getAvgSales() {
		return d.getFakeSalesPerDay();
	}
	
	public Report getAvgSalesByTrans() {
		return d.getFakeSalesPerTransaction();
	}
	
	public Report getVolByLoc() {
		return d.getFakeVolByLoc();
	}
	
	public Report getBlankReport() {
		return new Report("No Data", new ArrayList<ReportElement>());
	}
}
