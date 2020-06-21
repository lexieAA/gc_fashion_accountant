package com.smoothstack.gcfashion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.smoothstack.gcfashion.dao.UserDAO;
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

	public Object getSalesReport() {
		return uDAO.getSalesReport();
	}

	public Object getTaxReport() {
		return uDAO.getTaxReport();
	}

}
