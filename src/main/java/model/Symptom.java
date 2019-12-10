package model;

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
	// foreign key
	@ManyToOne
	private Entry entry;
	int entryId;
	
	public Symptom() {
		
	}

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
}
