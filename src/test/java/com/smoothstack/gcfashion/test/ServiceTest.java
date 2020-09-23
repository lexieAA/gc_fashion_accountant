package com.smoothstack.gcfashion.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.smoothstack.gcfashion.dao.ReportingDAO;
import com.smoothstack.gcfashion.entity.Report;
import com.smoothstack.gcfashion.entity.ReportElement;
import com.smoothstack.gcfashion.service.ReportService;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
	
	@Mock ReportingDAO rDao;
	@InjectMocks ReportService rs;
	
	@Before
	public void setUp() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Sales", BigDecimal.valueOf(36580.52)));		
		when(this.rDao.getSeriesData(any(String.class), any(LocalDate.class), any(LocalDate.class))).thenReturn(data);				
	}
	
	@Test
	public void testGetReport() {
		LocalDate startDate = LocalDate.now();
		LocalDate endDate = LocalDate.now();
		Boolean isLiveData = true;
		
		Report r1 = rs.getReport("salesbyloc", startDate, endDate, isLiveData);
		Report r2 = rs.getReport("taxesbyloc", startDate, endDate, isLiveData);
		Report r3 = rs.getReport("salesbycat", startDate, endDate, isLiveData);
		Report r4 = rs.getReport("totalsales", startDate, endDate, isLiveData);
		Report r5 = rs.getReport("totaltaxes", startDate, endDate, isLiveData);
		Report r6 = rs.getReport("avgsales", startDate, endDate, isLiveData);
		Report r7 = rs.getReport("salesbytransaction", startDate, endDate, isLiveData);
		Report r8 = rs.getReport("volbyloc", startDate, endDate, isLiveData);
		
		assertEquals(r1, rs.getSalesByLoc(startDate, endDate));
		assertEquals(r2, rs.getTaxesByLoc(startDate, endDate));
		assertEquals(r3, rs.getSalesByCat(startDate, endDate));
		assertEquals(r4, rs.getTotalSales(startDate, endDate));
		assertEquals(r5, rs.getTotalTaxes(startDate, endDate));
		assertEquals(r6, rs.getAvgSales(startDate, endDate));
		assertEquals(r7, rs.getSalesByTransaction(startDate, endDate));
		assertEquals(r8, rs.getVolByLocation(startDate, endDate));
	}

}
