package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * model class of entry
 * 
 * @author wackt2
 *
 */
public class Entry {
	// primary key
	int entryId;
	Date date;
	String title;
	String difficulty;
	String pride;
	String additional;
	Boolean privacy;
	ArrayList<Entry> activityList;
	ArrayList<Mood> moodList;
	ArrayList<Symptom> symptomList;
	// foreign keys
	int moodId;
	int userId;
	
	/*
	 * getter and setter methods
	 */
	public int getEntryId() {
		return entryId;
	}
	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getPride() {
		return pride;
	}
	public void setPride(String pride) {
		this.pride = pride;
	}
	public String getAdditional() {
		return additional;
	}
	public void setAdditional(String additional) {
		this.additional = additional;
	}
	public Boolean getPrivacy() {
		return privacy;
	}
	public void setPrivacy(Boolean privacy) {
		this.privacy = privacy;
	}
	public int getMoodId() {
		return moodId;
	}
	public void setMoodId(int moodId) {
		this.moodId = moodId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
