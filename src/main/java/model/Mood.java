package model;

/**
 * model class of mood
 * 
 * @author wackt2
 *
 */
public class Mood {
	// primary key
	int moodId;
	String name;
	
	/*
	 * ArrayList<Mood> moodList;
	 */
	
	/*
	 * getter and setter methods
	 */
	public int getMoodId() {
		return moodId;
	}
	public void setMoodId(int moodId) {
		this.moodId = moodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
