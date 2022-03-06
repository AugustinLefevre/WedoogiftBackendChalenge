package model.item;

public class Deposit {
	private static int id;
	private int issuingCompanyId;
	private int userId;
	public Deposit(int userId, int issuingCompanyId) {
		this.userId = userId;
		this.issuingCompanyId = issuingCompanyId;
		id++;
	}
	public static int getId() {
		return id;
	}
	public int getIssuingCompanyId() {
		return issuingCompanyId;
	}
	public int getUserId() {
		return userId;
	}
}
