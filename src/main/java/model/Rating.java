package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	//@ManyToOne
	//private final ArrayList<Exercise> exerciseList= new ArrayList<Exercise>();
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
	
	/* public ArrayList<Exercise> getExerciseList() {
		return exerciseList;
	}
	*/
/*
	public void setExerciseList(ArrayList<Exercise> exerciseList) {
		this.exerciseList = exerciseList;
	}
*/	
	public int getUserId() {
		return userId;
	}
	
	public int getExerciseId() {
		return exerciseId;
	}
}
