package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * model class of mood
 * 
 * @author wackt2
 *
 */
@Entity
public class Mood {
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int moodId;
	private String name;
	
	/*
	 * getter and setter methods
	 */
	public int getMoodId() {
		return moodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
