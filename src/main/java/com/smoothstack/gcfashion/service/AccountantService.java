package com.smoothstack.gcfashion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.smoothstack.gcfashion.dao.CategoryDAO;
import com.smoothstack.gcfashion.dao.CouponDAO;
import com.smoothstack.gcfashion.dao.ProductDAO;
import com.smoothstack.gcfashion.dao.StoreDAO;
import com.smoothstack.gcfashion.dao.SubcategoryDAO;
import com.smoothstack.gcfashion.dao.TransactionDAO;
import com.smoothstack.gcfashion.dao.UserDAO;
import com.smoothstack.gcfashion.entity.User;

public class AccountantService {

	@Autowired
	CategoryDAO cDAO;

	@Autowired
	CouponDAO cpDAO;

	@Autowired
	SubcategoryDAO scDAO;

	@Autowired
	StoreDAO sDAO;

	@Autowired
	ProductDAO pDAO;

	@Autowired
	TransactionDAO tDAO;

	@Autowired
	UserDAO uDAO;

	public List<User> findAllManagers() {
		return uDAO.findAll().stream().filter(user -> "management".equals(user.getRole())).collect(Collectors.toList());
	};
	
	public User findManagerById(Long userId) {
		return uDAO.findById(userId).orElse(null);
	};
	
	public Object getSalesReport() {
		return sDAO.getSalesReport();
	}

}
