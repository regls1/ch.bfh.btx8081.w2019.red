package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	/*
	 * getter and setter methods
	 */
	public int getId() {
		return cityId;
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
