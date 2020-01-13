package view;

import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

import model.Exercise;
import model.Rating;
import service.ExerciseService;

/**
 * A class which contains the details of the exercises
 * 
 * @author neues4
 *
 */

@SuppressWarnings("serial")
@Route
public class ExerciseDetailView4 extends VerticalLayout {

	// create new exercise service
	ExerciseService exsc = new ExerciseService();
	
	List<Exercise> allExercises = exsc.getAllExercises();

	/*
	 * constructor
	 */
	public ExerciseDetailView4() {

		/*
		 * return button
		 */
		Button btnReturn = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		btnReturn.setIconAfterText(false);
		btnReturn.addClickListener( e -> UI.getCurrent().navigate(ExerciseView.class));	

		Exercise exercise = allExercises.get(3);
		
		H1 exerciseTitle = new H1(exercise.getTitle());
		
		Label exerciseShortDescrp = new Label(exercise.getShortDescription());

		/*
		 * button to start the exercise
		 */
		Button btnStart = new Button("Start", new Icon(VaadinIcon.PLAY_CIRCLE_O));
		btnStart.setIconAfterText(false);

		/*
		 * add the components to the view
		 */
		add(btnReturn, exerciseTitle, exerciseShortDescrp, btnStart);

		/*
		 * create a new dialog to show further information of the exercise
		 * "abbrechen" to go back to the exercise detail view,
		 * "beenden" to finish the exercise
		 */
		Dialog dlgExerciseDetail = new Dialog();

		Button btnExit = new Button("Abbrechen", event -> {
			dlgExerciseDetail.close();
		});
		Button btnFinish = new Button("Beenden", event -> {
			dlgExerciseDetail.close();
		});

		Label exerciseDetailDescrp = new Label(exercise.getDetailDescription());

		//lblExerciseDetail.append(lblExerciseDetail.getValue());
		HorizontalLayout layout = new HorizontalLayout(btnExit, btnFinish);
		dlgExerciseDetail.add(exerciseDetailDescrp, layout);

		dlgExerciseDetail.setWidth("400px");
		dlgExerciseDetail.setHeight("600px");

		btnStart.addClickListener(event -> dlgExerciseDetail.open());

		/*
		 * dialog to rate the exercise after finishing 
		 */
		Dialog dlgRating = new Dialog();
		btnFinish.addClickListener(event -> dlgRating.open());

		RadioButtonGroup<String> rbgRating = new RadioButtonGroup<>();
		Rating rating1 = new Rating();
		Rating rating2 = new Rating();
		Rating rating3 = new Rating();
		Rating rating4 = new Rating();
		Rating rating5 = new Rating();
		rating1.setValue(1);
		rating2.setValue(2);
		rating3.setValue(3);
		rating4.setValue(4);
		rating5.setValue(5);
		String stringRating1 = String.valueOf(rating1.getValue());
		String stringRating2 = String.valueOf(rating2.getValue());
		String stringRating3 = String.valueOf(rating3.getValue());
		String stringRating4 = String.valueOf(rating4.getValue());
		String stringRating5 = String.valueOf(rating5.getValue());
		rbgRating.setItems(stringRating1, stringRating2, stringRating3, stringRating4, stringRating5);
		rbgRating.setLabel("Mit wie vielen Sternen bewertest du diese Übung?");

		Button btnOk = new Button("OK", event -> {
			/*
			Rating rating = new Rating();
			rating.setValue(rating1.getValue());
			exsc.addRating(rating);
			*/
			dlgRating.close();
		});

		Button btnClose = new Button("Abbrechen", event -> {
			dlgRating.close();
		});
		dlgRating.add(rbgRating, btnOk, btnClose);
	}


}
