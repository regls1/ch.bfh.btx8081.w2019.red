package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * model class of mood
 * 
 * @author wackt2
 *
 */
@Entity
public class Mood {
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int moodId;
	private String name;
	
	public Mood() {
		
	}
	
	public Mood(String name) {
		this.name = name;
	}
	
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "mood")
	private final ArrayList<Entry> entryList= new ArrayList<Entry>();
	
	/*
	 * getter and setter methods
	 */
	public int getMoodId() {
		return moodId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
