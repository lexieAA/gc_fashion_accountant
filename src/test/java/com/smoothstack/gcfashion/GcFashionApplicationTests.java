package com.smoothstack.gcfashion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.smoothstack.gcfashion.dao.UserDAO;
import com.smoothstack.gcfashion.entity.User;
import com.smoothstack.gcfashion.service.AccountantService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class GcFashionApplicationTests {
	
	@Mock
	UserDAO uDAO;
	
	@InjectMocks
	AccountantService acctService;

	@Test
	public void testGetInvalidUser() {
		
		Optional<User> optVal = Optional.empty();
		
		when(uDAO.findById(-1L)).thenReturn(optVal);
		assertNull(acctService.findManagerById(-1L));

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
