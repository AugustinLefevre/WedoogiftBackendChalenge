package model.item;

import java.util.Date;

public abstract class Deposit {
	private static int countId = 0;
	private int id;
	private int issuingCompanyId;
	private int userId;
	private float amount;
	private Date creationDate;
	protected Date expirationDate;
	
	public Deposit(int userId, int issuingCompanyId, float amount) {
		this.userId = userId;
		this.issuingCompanyId = issuingCompanyId;
		this.creationDate = new Date();
		this.amount = amount;
		setExpirationDate();
		id = countId++;
	}
	public Deposit(int userId, int issuingCompanyId, float amount, Date creationDate) {
		this.userId = userId;
		this.issuingCompanyId = issuingCompanyId;
		this.creationDate = creationDate;
		this.amount = amount;
		setExpirationDate();
		id = countId++;
	}
	public int getId() {
		return this.id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public int getIssuingCompanyId() {
		return issuingCompanyId;
	}
	public int getUserId() {
		return userId;
	}
	public abstract void setExpirationDate();
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	public float getAmount() {
		return this.amount;
	}
}
