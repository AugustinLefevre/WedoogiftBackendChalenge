package model.item;

import java.util.Calendar;
import java.util.Date;

public class Gift extends Deposit {
	public Gift(int userId, int issuingCompanyId, float amount) {
		super(userId, issuingCompanyId, amount);
	}
	
	public Gift(int userId, int issuingCompanyId, float amount, Date creationDate) {
		super(userId, issuingCompanyId, amount, creationDate);
	}
	/**
	 * this method is used in constructor
	 */
	@Override
	public void setExpirationDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getCreationDate());
		cal.add(Calendar.YEAR, 1);
		this.expirationDate = cal.getTime();
		
	}
}
