package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * model class of exercise
 * 
 * @author wackt2, romap1
 *
 */
@Entity
public class Exercise implements IEntity {
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int exerciseId;
	private String title;
	private String shortDescription;
	private String detailDescription;
	// foreign key
	@ManyToOne
	private int userId;

	/*
	 * getter and setter methods
	 */
	public int getId() {
		return exerciseId;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public String getDetailDescription() {
		return detailDescription;
	}
	
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	
	public int getUserId() {
		return userId;
	}
}
