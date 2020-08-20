package com.smoothstack.gcfashion.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.smoothstack.gcfashion.dao.UserDAO;
import com.smoothstack.gcfashion.entity.DummyData;
import com.smoothstack.gcfashion.entity.Report;
import com.smoothstack.gcfashion.entity.ReportElement;
import com.smoothstack.gcfashion.entity.User;
import com.smoothstack.gcfashion.service.AccountantService;

@RunWith(MockitoJUnitRunner.class)
public class BasicTest {
	
	@Mock
	UserDAO uDAO;
	
	@Mock
	DummyData dummy;
	
	@Mock
	Report report;
	
	@Mock
	ReportElement reportElement;
	
	@InjectMocks
	AccountantService acctService;
	
	@Test
	public void testGetInvalidUser() {
		
		List<ReportElement> testData = new ArrayList<ReportElement>();
		testData.add(new ReportElement("test", BigDecimal.valueOf(0)));
		Report testReport = new Report("test", testData);
		
		when(acctService.getAvgSales()).thenReturn(testReport);
		assertEquals(acctService.getAvgSales(), testReport);

	}
	
	@Test
	public void testGetValidUser() {
		User user = new User();
		user.setUserId(1L);
		user.setRole("management");
		
		when(uDAO.findById(1L)).thenReturn(Optional.of(user));		
		assertEquals(acctService.findManagerById(1L), user);

	}

}
