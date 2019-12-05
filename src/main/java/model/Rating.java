package model;

import java.util.ArrayList;

/**
 * model class of rating
 * 
 * @author wackt2
 *
 */
public class Rating {
	// primary key
	int ratingId;
	int value;
	ArrayList<Exercise> exerciseList;
	// foreign keys
	int userId;
	int exerciseId;
	
	/*
	 * getter and setter methods
	 */
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
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}
}