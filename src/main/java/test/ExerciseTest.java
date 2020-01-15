package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Exercise;
import presenter.ExercisePresenter;
import service.ExerciseService;

public class ExerciseTest {
	
	private ExercisePresenter presenter = new ExercisePresenter();
	private ExerciseService service = new ExerciseService();
	
	public int testGetExerciseId(String exerciseTitle) {
		int exerciseId = 1;
		for (Exercise exercise : service.getAllExercises()) {
			if (exercise.getTitle().equals(exerciseTitle)) {
				exerciseId = exercise.getId();
			}
		}
		
		return exerciseId;
	}
	
	@Test
	public void testExercise() {
		int id = this.testGetExerciseId("Einfaches Ansprechen auf der Strasse");
		Exercise exercise = presenter.getExercise(id);
		assertTrue(exercise.getDetailDescription().equals("Sprich fremde Menschen auf der Strasse an, um eine kurze Auskunft zu erfragen."));
		assertTrue(exercise.getShortDescription().equals("Sprich fremde Menschen auf der Strasse an, um eine kurze Auskunft zu erfragen."));
		assertTrue(exercise.getId() == 1);
	}
	
	

}
