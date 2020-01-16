package model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * model class of entry
 * 
 * @author wackt2, romap1
 *
 */
@Entity
public class Entry implements IEntity {
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int entryId;
	@Temporal(TemporalType.DATE)
	private Date date; 
	private String title;
	private String difficulty;
	private String pride;
	private String additional;
	private Boolean privacy;
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "entry")
	private final ArrayList<Activity> activityList= new ArrayList<Activity>();
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "entry")
	private ArrayList<Symptom> symptomList = new ArrayList<Symptom>();

	// foreign keys
	@ManyToOne
	private Mood mood;
	private int moodId;
	@ManyToOne
	private User user;
	private int userId;
	
	
	public Entry() {
		
	}
	
	public Entry(int id, String title, Date date, String difficulty, String pride, String additional, Boolean privacy) {
		this.entryId = id;
		this.title= title;
		this.date = date;
		this.difficulty = difficulty;
		this.pride = pride;
		this.additional = additional;
		this.privacy = privacy;
	}
	
	public Entry(int id, String title, Date date) {
		this.entryId = id;
		this.title= title;
		this.date = date;
	}
	
	/*
	 * getter and setter methods
	 */
	public int getId() {
		return entryId;
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