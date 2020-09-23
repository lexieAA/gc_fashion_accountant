package com.smoothstack.gcfashion.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.smoothstack.gcfashion.entity.ReportElement;

@Repository
public class ReportingDAO {

	@PersistenceContext	public EntityManager entityManager;	
	
	public List<ReportElement> getSeriesData(String queryString, LocalDate startDate, LocalDate endDate){
		Query query = entityManager.createNativeQuery(queryString);
		query.setParameter("startDate", Date.valueOf(startDate));
		query.setParameter("endDate", Date.valueOf(endDate));
		List<Object[]> results = Arrays.asList(query.getResultList().toArray()).stream().map(obj -> (Object[]) obj).collect(Collectors.toList());
		List<ReportElement> seriesData = results.stream().map(r -> new ReportElement((String) r[0], (BigDecimal) r[1])).collect(Collectors.toList());
		return seriesData;
	}	
}