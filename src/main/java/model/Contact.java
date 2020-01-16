package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * model class of contact
 * 
 * @author wackt2, romap1(added annotations)
 *
 */

@Entity
public class Contact implements IEntity {
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int contactId;
	private String title;
	private String firstName;
	private String name;
	private String mail;
	private String mobile;
	private String street;
	// foreign keys
	private Status statusId;
	@ManyToOne
	private City city;
	private int cityId;
	@ManyToOne
	private User user;
	private int userId;
	
	public Contact() {
		
	}
	
	public Contact(String title, String firstName, String name, String mail, String mobile, String street) {
		this.title = title;
		this.firstName = firstName;
		this.name = name;
		this.mail = mail;
		this.mobile = mobile;
		this.street = street;
	}
	
	/*
	 * getter and setter methods
	 */
	public int getId() {
		return contactId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
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

	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public Status getStatusId() {
		return statusId;
	}
	
	public void setStatusId(Status status) {
		this.statusId = status;
	}
	
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public int getCityId() {
		return cityId;
	}
	
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
}
