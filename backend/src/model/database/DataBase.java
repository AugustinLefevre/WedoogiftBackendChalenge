package model.database;

import java.util.HashMap;

import model.entity.Company;
import model.entity.User;
/**
 * used to simulate a DB
 * @author augustin.lefevre
 *
 */
public class DataBase {
	private static DataBase instance;
	private HashMap<Integer, Company> companies;
	private HashMap<Integer, User> users;
	
	private DataBase() {
		this.companies = new HashMap<Integer, Company>();
		this.users = new HashMap<Integer, User>();
	}
	public User getUserById(int id){
		return this.users.get(id);
	}
	public void addUser(User user) {		
		this.users.put(user.getId(), user);
		
	}
	public Company getCompanyById(int id){
		return this.companies.get(id);
	}
	public void addCompany(Company company) {
		this.companies.put(company.getId(), company);
	}
	public static DataBase getInstance() {
		if(instance == null) {
			instance = new DataBase();
			return instance;
		}
		else {
			return instance;
		}
	}
}
