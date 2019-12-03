package model;

/**
 * model class of status
 * 
 * @author wackt2
 *
 */
public class Status {
	// primary key
	int statusId;
	String value;
	
	/*
	 * getter and setter methods
	 */
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
