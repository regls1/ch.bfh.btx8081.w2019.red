package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * model class of rating
 * 
 * @author wackt2 & Khala1
 *
 */

@Entity
public class Rating {
	// primary key
	@Column(name = "ratingId")
	private int ratingId;
	@Column(name = "value")
	private int value;
	@Column(name = "exerciseList")
	private ArrayList<Exercise> exerciseList;
	// foreign keys
	@Column(name = "userId")
	private int userId;
	@Column(name = "exerciseId")
	private int exerciseId;
	
	/*
	 * getter and setter methods
	 */
	
	@Id
	@GeneratedValue
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
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
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	public int getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}
}
