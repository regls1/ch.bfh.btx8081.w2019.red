package model;

/**
 * model class of city
 * 
 * @author wackt2
 *
 */
public class City {
	// primary key
	int cityId;
	int zip;
	String name;
	
	/*
	 * getter and setter methods
	 */
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
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
