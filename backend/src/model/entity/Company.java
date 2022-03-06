package model.entity;

import model.database.DataBase;

public class Company {
	private static int id;
	private String name;
	private float balance;
	
	public Company(String name) {
		this.name = name;
		id++;
	}
	public int getId() {
		return this.getId();
	}
	/**
	 * send gift for a user if the company balance is sufficient to complete the transaction
	 * @param userId
	 * @param gift amount
	 */
	public void sendGift(int userId, float amount) {
		if(balance < 0 && amount <= balance) {
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
		if(balance < 0 && amount <= balance) {
			DataBase database = DataBase.getInstance();
			User user = database.getUserById(userId);
			user.addMeal(id, amount);
			this.balance -= amount;
		}
	}
}
