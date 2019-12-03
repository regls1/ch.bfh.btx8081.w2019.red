package model;

/**
 * model class of activity
 * 
 * @author wackt2
 *
 */
public class Activity {
	// primary key
	int activityId;
	String name;
	// foreign key
	int entryId;
	
	/*
	 * ArrayList<Activity> activityList;
	 * ArrayList<Entry> diaryEntryList;
	 */
	
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
