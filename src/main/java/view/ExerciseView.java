package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.red.SocialDisorderApp.MainView;


// WIRD BEARBEITET DURCH NEUES4!

@Route
public class ExerciseView extends VerticalLayout {

	// List<Exercise> exerciseList = new ArrayList<>();

	/*
	 * create a new grid to show the exercises
	 */
	private Grid<Exercise> exerciseGrid = new Grid<>();

	/*
	 * constructor: create new exercises (later we have to do this in the model)
	 * create an array list and add the exercises to this array list
	 * add a column to the grid and insert the exercise list
	 * create new button and link it back to the main view
	 * add the grid and button to the view
	 * add a new column to choose the exercise. Button is linked with exercise detail view
	 */
	public ExerciseView() {

		//add(new H1("I am a sample exercise view"));
		Exercise ex1 = new Exercise("Atemübung");
		Exercise ex2 = new Exercise("Yoga");
		Exercise ex3 = new Exercise("Fremde Menschen ansprechen");

		List<Exercise> exerciseList = new ArrayList<>();

		exerciseList.add(ex1);
		exerciseList.add(ex2);
		exerciseList.add(ex3);

		exerciseGrid.addColumn(Exercise::getExerciseName).setHeader("Exercises");

		exerciseGrid.setItems(exerciseList);
		
		Button btnReturn = new Button("Return");
		
		btnReturn.addClickListener( e -> UI.getCurrent().navigate(MainView.class));

		add(btnReturn, exerciseGrid);
		
		exerciseGrid.addColumn(new NativeButtonRenderer<>("choose", clickedItem ->
			UI.getCurrent().navigate(ExerciseDetailView.class)));

	}

	/*
	 * class for the exercises
	 */
	public class Exercise {

		private String exerciseName;

		/*
		 * constructor
		 */
		public Exercise(String exerciseName) {
			this.exerciseName = exerciseName;
		}

		/*
		 * method to return the exercise name
		 */
		public String getExerciseName() {
			return exerciseName;
		}
	}
}	


