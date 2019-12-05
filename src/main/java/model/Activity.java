package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * model class of  activity
 * 
 * @author wackt2, neues4
 *
 */
@Entity
public class Activity {
	// primary key
	@Id
	@GeneratedValue
	private int activityId;
	
	private String name;
	
	@ManyToOne
	private final ArrayList<Entry> diaryEntryList;
	// foreign key
	int entryId;
	
	/*
	 * getter and setter methods
	 */
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
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
	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}
}
