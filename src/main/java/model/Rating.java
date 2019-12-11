package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * model class of rating
 * 
 * @author wackt2 & Khala1
 *
 */

@Entity
public class Rating implements IEntity {
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int ratingId;
	private int value;
	// foreign keys
	@ManyToOne
	private User user;
	private int userId;
	@ManyToOne
	private Exercise exercise;
	private int exerciseId;
	
	public Rating() {
		
	}
	
	/*
	 * getter and setter methods
	 */
	public int getId() {
		return ratingId;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}
	
	public int getExerciseId() {
		return exerciseId;
	}
}
