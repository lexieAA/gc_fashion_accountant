package com.smoothstack.gcfashion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.smoothstack.gcfashion.dao.UserDAO;
import com.smoothstack.gcfashion.entity.DummyData;
import com.smoothstack.gcfashion.entity.Report;
import com.smoothstack.gcfashion.entity.User;

public class AccountantService {
	
	DummyData d = new DummyData();

	@Autowired
	UserDAO uDAO;

	public List<User> findAllManagers() {
		return uDAO.findAll().stream().filter(user -> "management".equals(user.getRole())).collect(Collectors.toList());
	};

	public User findManagerById(Long userId) {
		User user = uDAO.findById(userId).orElse(null);
		return "management".equals(user.getRole()) ? user : null;
	};

	public Report getSalesReport() {
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
}
