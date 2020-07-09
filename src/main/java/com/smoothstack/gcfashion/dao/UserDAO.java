package com.smoothstack.gcfashion.dao;

import org.springframework.stereotype.Repository;

import com.smoothstack.gcfashion.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

	@Query(value = "select s.store_name, SUM(t.total) from store s left join transaction t on s.store_id = t.store_id group by store_name", nativeQuery = true)
	List<Object[]> getSalesReport();

	@Query(value = "select s.store_name, SUM(t.tax) from store s left join transaction t on s.store_id = t.store_id group by store_name", nativeQuery = true)
	List<Object[]> getTaxReport();

	@Query(value = "select c.cat_name, p.price from transaction_inventory ti join inventory i join product p join category c on ti.sku = i.sku and i.product_id = p.product_id and p.cat_id = c.cat_id", nativeQuery = true)
	List<Object[]> getSalesByCat();
	
	@Query(value = "select sum(t.total) from transaction t", nativeQuery = true)
	List<Object[]> getTotalSales();
	
	@Query(value = "select sum(t.tax) from transaction t", nativeQuery = true)
	List<Object[]> getTotalTaxes();

}