package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import model.entity.Company;
import model.entity.User;
import model.item.Deposit;
import model.item.Gift;
import model.item.Meal;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {
	private User user;
	private Company company;
	public UserTest() {
		this.user = new User("User name");
		this.company = new Company("Company name");
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		
	}
	@Test()
	@Order(1)
	public void testUserConstructor() {
		assertNotNull(this.user, "User constructor not working");
	}
	@Test
	@Order(2)
	public void testGetId() {
		assertEquals(this.user.getId() + 1, new User("test").getId(), "user id is not what is expected");
	}
	@Test
	@Order(3)
	public void testAddGift() {
		int currentListLength = this.user.getGifts().size();
		this.user.addGift(this.company.getId(), 100);
		assertNotEquals(currentListLength, this.user.getGifts().size(),"Gift not added");
	}
	@Test
	@Order(4)
	public void testAddMeal() {
		int currentListLength = this.user.getMeals().size();
		this.user.addMeal(this.company.getId(), 100);
		assertNotEquals(currentListLength, this.user.getMeals().size(),"Meal not added");
	}
	@Test
	@Order(5)
	public void testGetGifts(){
		List<Deposit> giftsTest = new ArrayList<Deposit>();
		giftsTest.add(new Gift(this.user.getId(), this.company.getId(), 100));
		this.user.addGift(this.company.getId(), 100);
		assertEquals(giftsTest.size(), this.user.getGifts().size(), "user gift list size is not what it is expected");
		Gift giftTest = (Gift) giftsTest.get(giftsTest.size()-1);
		Gift userGift = (Gift) this.user.getGifts().get(this.user.getGifts().size() -1);
		assertEquals(giftTest.getIssuingCompanyId(), giftTest.getIssuingCompanyId(), "addGift does not what is expected");
		assertEquals(giftTest.getAmount(), giftTest.getAmount(), "addGift does not what is expected");
		assertEquals(giftTest.getUserId(), giftTest.getUserId(), "addGift does not what is expected");
		assertEquals(giftTest.getClass(), giftTest.getClass(), "addGift does not what is expected");
		assertEquals(giftTest.getCreationDate(), giftTest.getCreationDate(), "addGift does not what is expected");
		assertEquals(giftTest.getExpirationDate(), giftTest.getExpirationDate(), "addGift does not what is expected");
		assertNotEquals(giftTest.getId(), userGift.getId(), "addGift does not what is expected");		
	}
	@Test
	@Order(6)
	public void testGetMeals(){
		List<Deposit> mealsTest = new ArrayList<Deposit>();
		mealsTest.add(new Meal(this.user.getId(), this.company.getId(), 100));
		this.user.addMeal(this.company.getId(), 100);
		assertEquals(mealsTest.size(), this.user.getMeals().size(), "user meal list size is not what it is expected");
		Meal mealTest = (Meal) mealsTest.get(mealsTest.size()-1);
		Meal userMeal = (Meal) this.user.getMeals().get(this.user.getMeals().size() -1);
		assertEquals(mealTest.getIssuingCompanyId(), mealTest.getIssuingCompanyId(), "addMeal does not what is expected");
		assertEquals(mealTest.getAmount(), mealTest.getAmount(), "addMeal does not what is expected");
		assertEquals(mealTest.getUserId(), mealTest.getUserId(), "addMeal does not what is expected");
		assertEquals(mealTest.getClass(), mealTest.getClass(), "addMeal does not what is expected");
		assertEquals(mealTest.getCreationDate(), mealTest.getCreationDate(), "addMeal does not what is expected");
		assertEquals(mealTest.getExpirationDate(), mealTest.getExpirationDate(), "addMeal does not what is expected");
		assertNotEquals(mealTest.getId(), userMeal.getId(), "addMeal does not what is expected");
	}
	@Test
	@Order(7)
	public void testGetDepositsBalance() {
		this.user.addGift(this.company.getId(), 100);
		this.user.addMeal(this.company.getId(), 100);
		assertEquals(100.0,this.user.getDepositsBalance(this.user.getGifts()), "the Gifts amount is not correct");
		assertEquals(100.0, this.user.getDepositsBalance(this.user.getMeals()),"the Meals amount is not correct");
		
		Calendar calTest = new GregorianCalendar(2010, 1, 12);
		Date earlyDate = calTest.getTime();
		this.user.addGift(this.company.getId(), 100, earlyDate);
		this.user.addMeal(this.company.getId(), 100, earlyDate);
		assertEquals(100.0,this.user.getDepositsBalance(this.user.getGifts()), "Gift balance can not use expired deposit");
		assertEquals(100.0, this.user.getDepositsBalance(this.user.getMeals()),"Gift balance can not use expired deposit");
	}
	@Test
	@Order(8)
	public void testGetName(){
		assertTrue(this.user.getName().equals("User name"), "Name is not corresponding");
	}
}
