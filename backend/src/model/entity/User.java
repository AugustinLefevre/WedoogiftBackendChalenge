package model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.database.DataBase;
import model.item.Deposit;
import model.item.Gift;
import model.item.Meal;

public class User {
	
	private static int countId;
	private int id;
	private String name;
	private List<Deposit> gifts;
	private List<Deposit> meals;
	
	public User(String name) {
		this.gifts = new ArrayList<Deposit>();
		this.meals = new ArrayList<Deposit>();
		this.name = name;
		id = countId++;
		DataBase.getInstance().addUser(this);
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	/**
	 * add gift for the current user
	 * @param company Id
	 * @param gift amount
	 */
	public void addGift(int companyId, float amount) {
		Gift gift = new Gift(id, companyId, amount);
		this.gifts.add(gift);
	}
	/**
	 * add gift for the current user to a specified date
	 * @param company Id
	 * @param gift amount
	 */
	public void addGift(int companyId, float amount, Date creationDate) {
		Gift gift = new Gift(id, companyId, amount, creationDate);
		this.gifts.add(gift);
	}
	/**
	 * add meal for the current user
	 * @param company Id
	 * @param gift amount
	 */
	public void addMeal(int companyId, float amount) {
		Meal meal = new Meal(id, companyId, amount);
		this.meals.add(meal);
	}
	/**
	 * add meal for the current user to a specified date
	 * @param company Id
	 * @param gift amount
	 */
	public void addMeal(int companyId, float amount, Date creationDate) {
		Meal meal = new Meal(id, companyId, amount, creationDate);
		this.meals.add(meal);
	}
	/**
	 * return the amount of available deposit in the deposit collection passed in parameter
	 * @param deposits List of deposits
	 * @return all the available deposits amount
	 */
	public float getDepositsBalance(List<Deposit> deposits) {
		Date today = new Date();
		
		float result = 0;
		for(Deposit depo : deposits) {
			int dateComparator = today.compareTo(depo.getExpirationDate());
			// current date is before gift expiration
			if(dateComparator <= 0) {
				result += depo.getAmount();
			}
		}
		return result;
	}
	public List<Deposit> getGifts(){
		return this.gifts;
	}
	public List<Deposit> getMeals(){
		return this.meals;
	}
	
}
