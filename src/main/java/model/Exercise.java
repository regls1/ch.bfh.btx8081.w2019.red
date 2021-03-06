package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * model class of exercise
 * 
 * @author wackt2, romap1(annotations)
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
	private User user;
	private int userId;
	
	public Exercise() {
		
	}
	
	public Exercise(String title, String shortDescription, String detailDescription) {
		this.title = title;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
		
	}
	
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "exercise")
	private final ArrayList<Rating> ratingList = new ArrayList<Rating>();

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
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
}
