package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import model.entity.Company;
import model.entity.User;

public class CompanyTest {

	private User user;
	private Company company;
	
	public CompanyTest() {
		this.user = new User("User name");
		this.company = new Company("Company name");
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		
	}
	@Test()
	@Order(1)
	public void testUserConstructor() {
		assertNotNull(this.company, "Company constructor not working");
		assertTrue(this.company.getName().equals("Company name"), "Name not corresponding");
	}
	@Test
	@Order(2)
	public void testIncreaseBalance(){
		this.company.increaseBalance(100);
		this.company.increaseBalance(-100);
		assertEquals(100.0, this.company.getBalance(), "balance is not correspondin");
		assertNotEquals(0, this.company.getBalance(), "increase methode not accepte negative value");
	}
	@Test
	@Order(3)
	public void testSendGift() {
		this.company.sendGift(this.user.getId(), 100);
		assertEquals(0.0, this.user.getDepositsBalance(this.user.getGifts()), "Company can't  send gift more expensive than their current balance");
		this.company.increaseBalance(100);
		this.company.sendGift(this.user.getId(), 1000);
		assertNotEquals(1000.0, this.user.getDepositsBalance(this.user.getGifts()), "Company can't  send gift more expensive than their current balance");
		this.company.sendGift(this.user.getId(), 100);
		assertEquals(100.0, this.user.getDepositsBalance(this.user.getGifts()), "send gift doesn't work");
		this.company.sendGift(this.user.getId(), -50);
		assertEquals(100.0, this.user.getDepositsBalance(this.user.getGifts()), "gift amount cannot be negative");

	}
	@Test
	@Order(4)
	public void testSendMeal() {
		this.company.sendMeal(this.user.getId(), 100);
		assertEquals(0.0, this.user.getDepositsBalance(this.user.getMeals()), "Company can't  send meal more expensive than their current balance");
		this.company.increaseBalance(100);
		this.company.sendMeal(this.user.getId(), 1000);
		assertNotEquals(1000.0, this.user.getDepositsBalance(this.user.getMeals()), "Company can't  send meal more expensive than their current balance");
		this.company.sendMeal(this.user.getId(), 100);
		assertEquals(100.0, this.user.getDepositsBalance(this.user.getMeals()), "send meal doesn't work");
		this.company.sendMeal(this.user.getId(), -50);
		assertEquals(100.0, this.user.getDepositsBalance(this.user.getMeals()), "meal amount cannot be negative");

	}
	
}
