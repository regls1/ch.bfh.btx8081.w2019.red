package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private ArrayList<Exercise> exerciseList;
	// foreign keys
	private int userId;
	private int exerciseId;
	
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
	
	public int getUserId() {
		return userId;
	}
	
	public int getExerciseId() {
		return exerciseId;
	}
}
