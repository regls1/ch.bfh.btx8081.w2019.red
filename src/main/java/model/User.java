package model;

/**
 * model class of user
 * 
 * @author wackt2
 *
 */
public class User {
	// primary key
	int userId;
	String firstName;
	String name;
	
	/*
	 * getter and setter methods
	 */
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
