package com.smoothstack.gcfashion.dao;
import org.springframework.stereotype.Repository;

import com.smoothstack.gcfashion.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	
	@Query(value = "select s.store_name, SUM(t.total) from store s left join transaction t on s.store_id = t.store_id group by store_name", nativeQuery = true)
	List<Object[]> getSalesReport();
	
	@Query(value = "select s.store_name, SUM(t.tax) from store s left join transaction t on s.store_id = t.store_id group by store_name", nativeQuery = true)
	List<Object[]> getTaxReport();
	

}