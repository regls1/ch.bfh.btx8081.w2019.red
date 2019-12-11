package model;

import java.util.ArrayList;

public class ExerciseModel {
	
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
		return (ArrayList<Exercise>)EntityService.em.createQuery("select c from Contact c").getResultList();
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
		
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
		
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
		
		EntityService.em.persist(e);
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
		
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
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
	}
}
