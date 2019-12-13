package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * model class of city
 * 
 * @author wackt2, romap1
 *
 */
@Entity 
public class City implements IEntity {
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int cityId;
	private int zip;
	private String name;
	
	public City() {
		
	}
	
	public City(int zip, String name) {
		this.zip = zip;
		this.name = name;
	}
	
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "city")
	private final ArrayList<Contact> contactList= new ArrayList<Contact>();
	
	/*
	 * getter and setter methods
	 */
	public int getId() {
		return cityId;
	}
	
	public void setId(int cityId) {
		this.cityId = cityId;
	}

	
	public int getZip() {
		return zip;
	}
	
	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
