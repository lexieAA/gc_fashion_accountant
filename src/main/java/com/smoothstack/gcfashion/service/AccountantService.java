package com.smoothstack.gcfashion.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.smoothstack.gcfashion.dao.UserDAO;
import com.smoothstack.gcfashion.entity.SalesReport;
import com.smoothstack.gcfashion.entity.TaxReport;
import com.smoothstack.gcfashion.entity.User;

public class AccountantService {

	@Autowired
	UserDAO uDAO;

	public List<User> findAllManagers() {
		return uDAO.findAll().stream().filter(user -> "management".equals(user.getRole())).collect(Collectors.toList());
	};

	public User findManagerById(Long userId) {
		User user = uDAO.findById(userId).orElse(null);
		return "management".equals(user.getRole()) ? user : null;
	};

	public List<SalesReport> getSalesReport() {
		return uDAO.getSalesReport().stream().map(r -> new SalesReport((String)r[0],(BigDecimal)r[1])).collect(Collectors.toList());
	}

	public List<TaxReport> getTaxReport() {
		return uDAO.getTaxReport().stream().map(r -> new TaxReport((String)r[0],(BigDecimal)r[1])).collect(Collectors.toList());
	}

}
