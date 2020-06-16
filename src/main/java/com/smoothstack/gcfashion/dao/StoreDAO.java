package com.smoothstack.gcfashion.dao;

import org.springframework.stereotype.Repository;
import com.smoothstack.gcfashion.entity.Store;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface StoreDAO extends JpaRepository<Store, Long> {
	
	@Query(value = "select s.store_name, SUM(t.total) from store s left join transaction t on s.store_id = t.store_id group by store_name", nativeQuery = true)
	Object getSalesReport();
	
}
