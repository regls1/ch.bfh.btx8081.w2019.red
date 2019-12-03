package model;
/**
 * model class of symptom
 * 
 * @author wackt2
 *
 */
public class Symptom {
	// primary key
	int symptomId;
	String name;
	// foreign key
	int entryId;
	
	/*
	 * ArrayList<Entry> diaryEntryList;
	 */
	
	/*
	 * getter and setter methods
	 */
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
