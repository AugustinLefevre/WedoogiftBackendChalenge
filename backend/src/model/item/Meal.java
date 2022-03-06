package model.item;

import java.util.Calendar;

public class Meal extends Deposit {
	
	public Meal(int userId, int issuingCompanyId, float amount) {
		super(userId, issuingCompanyId, amount);
	}

	@Override
	public void setExpirationDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getCreationDate());
		cal.add(Calendar.YEAR, 1);
		cal.set(Calendar.MONTH, 1);
		cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		this.expirationDate = cal.getTime();
		
	}
}
