package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int symptomId;
	private String name;
	private ArrayList<Entry> diaryEntryList;
	// foreign key
	int entryId;

	/*
	 * getter and setter methods
	 */
	public int getSymptomId() {
		return symptomId;
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
}
