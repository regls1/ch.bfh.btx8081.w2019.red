package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * model class of user
 * 
 * @author wackt2 @ Khala1
 *
 */

@Entity
public class User implements IEntity {
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int userId;
	private String firstName;
	private String name;

	public User() {

	}

	public User(String firstName, String name) {
		this.firstName = firstName;
		this.name = name;
	}

	@OneToMany (fetch = FetchType.EAGER, mappedBy = "user")
	private final ArrayList<Entry> entryList= new ArrayList<Entry>();
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "user")
	private final ArrayList<Contact> contactList= new ArrayList<Contact>();
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "user")
	private final ArrayList<Exercise> exerciseList= new ArrayList<Exercise>();
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "user")
	private final ArrayList<Rating> RatingList= new ArrayList<Rating>();

	/*
	 * getter and setter methods
	 */
	public int getId() {
		return userId;
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
