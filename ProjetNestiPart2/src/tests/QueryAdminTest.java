package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import entities.Admin;
import model.QueryAdmin;

public class QueryAdminTest {

	@Test
	public void testCreatePrepared() throws Exception {
		
		Admin adm= new Admin("pierre", "dupond", "pierre.dupond"+LocalTime.now(), "123", "unblocked");
		
		QueryAdmin qm = new QueryAdmin();
		
		assertTrue(qm.createPrepared(adm));
	}
	
	
	@Test
	public void testCheckPassword() throws Exception {
		
		QueryAdmin qm = new QueryAdmin();

	
		
		assertTrue(qm.checkPassword("pierre.dupond", "123"));

		assertFalse(qm.checkPassword("isa.durand", "Titi@12345"));

		
	}

}
