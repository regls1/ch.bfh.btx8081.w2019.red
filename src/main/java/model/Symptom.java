package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * model class of symptom
 * 
 * @author wackt2 & Khala1
 *
 */

@Entity
public class Symptom {
	// primary key

	@Column(name = "symptomId")
	private int symptomId;

	@Column(name = "name")
	private String name;

	@Column(name = "diaryEntryList")
	
	private ArrayList<Entry> diaryEntryList;
	// foreign key

	@Column(name = "entryId")
	int entryId;

	/*
	 * getter and setter methods
	 */

	@Id
	@GeneratedValue
	public int getSymptomId() {
		return symptomId;
	}

	public void setSymptomId(int symptomId) {
		this.symptomId = symptomId;
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
