package model.item;

import java.util.Calendar;

public class Gift extends Deposit {
	public Gift(int userId, int issuingCompanyId, float amount) {
		super(userId, issuingCompanyId, amount);
	}

	@Override
	public void setExpirationDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getCreationDate());
		cal.add(Calendar.YEAR, 1);
		this.expirationDate = cal.getTime();
		
	}
}
