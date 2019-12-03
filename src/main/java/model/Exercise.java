package model;

/**
 * model class of exercise
 * 
 * @author wackt2
 *
 */
public class Exercise {
	// primary key
	int exerciseId;
	String title;
	String shortDescription;
	String detailDescription;
	// foreign key
	int userId;
	
	/*
	 * ArrayList<Exercise> exerciseList;
	 */
	
	/*
	 * getter and setter methods
	 */
	public int getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
