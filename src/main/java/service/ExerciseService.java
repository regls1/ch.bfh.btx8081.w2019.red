package service;

import java.util.ArrayList;

import model.EntityService;
import model.Exercise;
import model.Rating;
import model.User;

public class ExerciseService {
	
	/**
	 * get an user based on the id 
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		return EntityService.em.find(User.class, id);
	}
	
	/**
	 * get a list of all exercises
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Exercise> getAllExercises() {
		return (ArrayList<Exercise>)EntityService.em.createQuery("select e from Exercise e").getResultList();
	}
 
	/**
	 * get an exercise based on the id
	 * @param id
	 * @return
	 */
	public Exercise getExerise(int id) {
		return EntityService.em.find(Exercise.class, id);
	}
	
	/**
	 * update existing exercise
	 * @param id
	 * @param exercise
	 * @return
	 */
	public Exercise updateExercise(int id, Exercise exercise) {
		EntityService.em.getTransaction().begin();
		
		Exercise e = EntityService.em.find(Exercise.class, id);
		
		e.setTitle(exercise.getTitle());
		e.setShortDescription(exercise.getShortDescription());
		e.setDetailDescription(exercise.getDetailDescription());
		// user id stays the same
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return e;
	}
 
	/**
	 * add an exercise 
	 * @param exercise
	 * @return
	 */
	public Exercise addExercise(Exercise exercise) {
		EntityService.em.getTransaction().begin();
		
		Exercise e = new Exercise();
		
		e.setTitle(exercise.getTitle());
		e.setShortDescription(exercise.getShortDescription());
		e.setDetailDescription(exercise.getDetailDescription());
		e.setUserId(exercise.getUserId());
		
		EntityService.em.persist(e);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return e;
	}	
 
	/**
	 * delete an exercise
	 * @param exercise
	 */
	public void deleteCustomer(int id) {
		Exercise e = EntityService.em.find(Exercise.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(e);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
	}
	
	/**
	 * get a list of all ratings
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Rating> getAllRatings() {
		return (ArrayList<Rating>)EntityService.em.createQuery("select r from Rating r").getResultList();
	}
 
	/**
	 * get a rating based on the id
	 * @param id
	 * @return
	 */
	public Rating getRating(int id) {
		return EntityService.em.find(Rating.class, id);
	}
	
	/**
	 * update existing rating
	 * @param id
	 * @param rating
	 * @return
	 */
	public Rating updateRating(int id, Rating rating) {
		EntityService.em.getTransaction().begin();
		
		Rating r = EntityService.em.find(Rating.class, id);
		
		r.setValue(rating.getValue());
		// foreign keys userid and exerciseid stay the same
		
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return r;
	}
 
	/**
	 * add a rating 
	 * @param rating
	 * @return
	 */
	public Rating addRating(Rating rating) {
		EntityService.em.getTransaction().begin();
		
		Rating r = new Rating();
		
		r.setValue(rating.getValue());
		r.setUserId(rating.getUserId());
		r.setExerciseId(rating.getExerciseId());
		
		EntityService.em.persist(r);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return r;
	}	
 
	/**
	 * delete a rating
	 * @param rating
	 */
	public void deleteRating(int id) {
		Rating r = EntityService.em.find(Rating.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(r);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
	}
}
