package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * model class of user
 * 
 * @author wackt2 @ Khala1
 *
 */

@Entity
@Table (name = "User")
public class User {
	// primary key
	
	@Column(name = "id")
	private int userId;
	
	@Column(name = "name")
	private String firstName;
	
	@Column(name = "age")
	private String name;

	/*
	 * getter and setter methods
	 */
	
	@Id
	@GeneratedValue
	public int getUserId() {
		return userId;
	}

//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	
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
