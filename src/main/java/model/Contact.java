package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * model class of contact
 * 
 * @author wackt2, romap1
 *
 */

@Entity
public class Contact {
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
	
	private Enum<Status> statusId;
	@ManyToOne
	private int cityId;
	@ManyToOne
	private int userId;
	
	
	/*
	 * getter and setter methods
	 */
	public int getContactId() {
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
	public Enum<Status> getStatusId() {
		return statusId;
	}
	public void setStatusId(Enum<Status> status) {
		this.statusId = status;
	}
	
	public int getCityId() {
		return cityId;
	}
	
	public int getUserId() {
		return userId;
	}

	
}
