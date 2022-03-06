package model.entity;

import java.util.List;

import model.item.Gift;
import model.item.Meal;

public class User {
	
	private static int id;
	private String name;
	private List<Gift> gifts;
	private List<Meal> meals;
	
	public User(String name) {
		this.name = name;
		id++;
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
		gifts.add(gift);
	}
	/**
	 * add meal for the current user
	 * @param company Id
	 * @param gift amount
	 */
	public void addMeal(int companyId, float amount) {
		Meal meal = new Meal(id, companyId, amount);
		meals.add(meal);
	}
}
