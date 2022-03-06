package model.item;

import java.util.Date;

public abstract class Deposit {
	private static int id;
	private int issuingCompanyId;
	private int userId;
	private float amount;
	private Date creationDate;
	protected Date expirationDate;
	
	public Deposit(int userId, int issuingCompanyId, float amount) {
		this.userId = userId;
		this.issuingCompanyId = issuingCompanyId;
		this.creationDate = new Date();
		setExpirationDate();
		id++;
	}
	public static int getId() {
		return id;
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
	public float getMount() {
		return this.amount;
	}
}
