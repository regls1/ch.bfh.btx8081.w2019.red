package model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
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
	
	@OneToMany (mappedBy = "entryId")
	private ArrayList<Activity> activityList;
	@OneToMany (mappedBy = "entryId")
	private ArrayList<Symptom> symptomList;
	// foreign keys
	@ManyToOne
	private int moodId;
	@ManyToOne
	private int userId;
	
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
	
	public int getUserId() {
		return userId;
	}
}
