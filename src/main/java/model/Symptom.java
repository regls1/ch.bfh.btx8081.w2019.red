package model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * model class of symptom
 * 
 * @author wackt2 & Khala1
 *
 */

@Entity
public class Symptom implements IEntity {
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int symptomId;
	private String name;
	private ArrayList<Entry> diaryEntryList;
	// foreign key
	@ManyToOne
	Entry entry;
	int entryId;

	/*
	 * getter and setter methods
	 */
	public int getId() {
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

	public ArrayList<Entry> getDiaryEntryList() {
		return diaryEntryList;
	}

	public void setDiaryEntryList(ArrayList<Entry> diaryEntryList) {
		this.diaryEntryList = diaryEntryList;
	}
}
