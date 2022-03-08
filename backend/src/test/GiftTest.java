package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import model.item.Gift;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GiftTest {
	
	public GiftTest() {
		
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		
	}
	
	@Test
	@Order(1)
	public void testGiftConstructor() {
		Gift depo = new Gift(1, 1, 1);
		assertNotNull(depo, "gift constructor won't work");
		Calendar cal = new GregorianCalendar(2014, 01, 12);
		Date dateTest = cal.getTime();
		Gift depo2 = new Gift(1, 1, 1, dateTest);
		assertNotNull(depo2, "gift constructor won't work");
	}
	@Test
	@Order(2)
	public void testGetCreationDate(){
		Gift depo = new Gift(1, 1, 1);
		assertEquals(new Date(), depo.getCreationDate(), "creation date is not corresponding");
	}
	@Test
	@Order(3)
	public void testGetExpirationDate() {
		Calendar cal = new GregorianCalendar(2014, 01, 12);
		Date dateTest = cal.getTime();
		Gift depo = new Gift(1, 1, 1, dateTest);
		Calendar calTest = new GregorianCalendar(2015, 01, 12);
		Date expirationTest = calTest.getTime();
		assertEquals(expirationTest, depo.getExpirationDate(), "expiration is not that is expected");
	}
}
