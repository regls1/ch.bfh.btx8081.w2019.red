package presenter;

import java.util.List;

import model.Exercise;
import model.Rating;
import service.ExerciseService;

/**
 * exercise presenter
 * 
 * @author wackt2, neues4
 */

public class ExercisePresenter {
	private Rating rating;
	private ExerciseService service = new ExerciseService();
	
	/**
	 * method to return all existing exercises
	 * @return List of all exercises
	 */
	public List<Exercise> getAllExercises() {
		return service.getAllExercises();
	}
	
	/**
	 * method to return an existing exercise by id
	 * @return exercise object
	 */
	public Exercise getExercise(int id) {
		return service.getExercise(id);
	}
	
	/**
	 * method to return all existing ratings
	 * @return List of all ratings
	 */
	public List<Rating> getAllRatings() {
		return service.getAllRatings();
	}
	
	/**
	 * method to return an existing rating by id
	 * @return contact object
	 */
	public Rating getRating(int id) {
		return service.getRating(id);
	}

	/**
	 * method to save a rating
	 * 
	 * @param value, rating value
	 * @param userId, id of current user
	 * @param exerciseId, id of exercise
	 */
	public void saveRating(int value, int exerciseId) {
		// set all attributes
		rating = new Rating();
		rating.setValue(value);
		//rating.setUserId(userId);
		
		rating.setExerciseId(exerciseId);
		
		service.addRating(rating);
	}
	
	/**
	 * 
	 * @param id, id of existing rating
	 * @param value, rating value
	 * @param userId, id of current user
	 * @param exerciseId, id of exercise
	 */
	public void updateRating(int id, int value, int userId, int exerciseId) {
		Rating r = this.getRating(id);
		rating.setValue(value);
		rating.setUserId(userId);
		rating.setExerciseId(exerciseId);
		
		service.updateRating(r.getId(), rating);
	}
	
}
