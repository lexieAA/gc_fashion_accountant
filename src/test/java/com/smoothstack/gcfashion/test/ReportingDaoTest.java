package com.smoothstack.gcfashion.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.smoothstack.gcfashion.dao.ReportingDAO;
import com.smoothstack.gcfashion.entity.ReportElement;

@RunWith(MockitoJUnitRunner.class)
public class ReportingDaoTest {

	ReportingDAO reportingDAO;	

	@Before
	public void setUp() {
		this.reportingDAO = new ReportingDAO();
		this.reportingDAO.entityManager = mock(EntityManager.class);		
	}	

	@Test
	public void testGetSeriesData() {		
		mockQuery();		
		List<ReportElement> dataFromDAO = this.reportingDAO.getSeriesData("test query", LocalDate.now(), LocalDate.now());
		List<ReportElement> testData = new ArrayList<>();
		testData.add(new ReportElement("label1", BigDecimal.valueOf(1.10)));
		testData.add(new ReportElement("label2", BigDecimal.valueOf(2.20)));
		
		assertNotNull(dataFromDAO);
		assertEquals(dataFromDAO, testData);
	}
	
	public void mockQuery() {
		Object[] arr1 = { "label1", BigDecimal.valueOf(1.10) };
		Object[] arr2 = { "label2", BigDecimal.valueOf(2.20) };
		Query q = mock(Query.class);
		when(q.getResultList()).thenReturn(List.of(arr1,arr2));
		when(q.setParameter(any(String.class), any(Object.class))).thenReturn(q);
		when(this.reportingDAO.entityManager.createNativeQuery(any(String.class))).thenReturn(q);		
	}
}