package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * model class of  activity
 * 
 * @author wackt2, neues4
 *
 */

@Entity
public class Activity implements IEntity {
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int activityId;
	
	private String name;
	
	// foreign key
	int entryId;
	@ManyToOne
	private Entry entry;
	
	public Activity() {
		
	}
	
	/*
	 * getter and setter methods
	 */
	public int getId() {
		return activityId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getEntryId() {
		return entryId;
	}
	
}
