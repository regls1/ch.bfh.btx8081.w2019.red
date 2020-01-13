package presenter;

import java.util.List;

import model.Exercise;
import service.ExerciseService;

/**
 * 
 * @author neues4
 *
 */
public class ExercisePresenter {

	// create new Exercise Service
	private ExerciseService exService = new ExerciseService();

	/**
	 * Method to return a list of all exercises from the database
	 * @return List of all exercises form the database
	 */
	public List<Exercise> getAllExercises() {
		return exService.getAllExercises();
	}
}
