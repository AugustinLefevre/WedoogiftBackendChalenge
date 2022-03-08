package model.entity;

import model.database.DataBase;

public class Company {
	private static int countId;
	private int id;
	private String name;
	private float balance;
	
	public Company(String name) {
		
		this.name = name;
		id = countId++;
		DataBase.getInstance().addCompany(this);
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void increaseBalance(float amount) {
		if(amount > 0)
			this.balance += amount;
	}
	public float getBalance() {
		return this.balance;
	}
	/**
	 * send gift for a user if the company balance is sufficient to complete the transaction
	 * @param userId
	 * @param gift amount
	 */
	public void sendGift(int userId, float amount) {
		
		if(balance > 0 && amount <= balance && amount > 0) {
			DataBase database = DataBase.getInstance();
			User user = database.getUserById(userId);
			user.addGift(id, amount);
			this.balance -= amount;
		}
	}
	/**
	 * send meal for a user if the company balance is sufficient to complete the transaction
	 * @param userId
	 * @param meal amount
	 */
	public void sendMeal(int userId, float amount) {
		if(balance > 0 && amount <= balance && amount > 0) {
			DataBase database = DataBase.getInstance();
			User user = database.getUserById(userId);
			user.addMeal(id, amount);
			this.balance -= amount;
		}
	}
}
