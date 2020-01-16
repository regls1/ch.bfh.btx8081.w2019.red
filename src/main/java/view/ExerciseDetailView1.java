package view;

import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

import model.Exercise;
import model.Rating;
import presenter.ExercisePresenter;
import service.ExerciseService;

/**
 * A class which contains the details of the exercises
 * 
 * @author neues4
 *
 */

@SuppressWarnings("serial")
@Route
public class ExerciseDetailView1 extends VerticalLayout {

	// create new exercise service
	ExerciseService exsc = new ExerciseService();
	
	List<Exercise> allExercises = exsc.getAllExercises();
	ExercisePresenter presenter = new ExercisePresenter();
	Exercise exercise;
	

	/*
	 * constructor
	 */
	public ExerciseDetailView1() {

		/*
		 * return button
		 */
		Button btnReturn = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		btnReturn.setIconAfterText(false);
		btnReturn.addClickListener( e -> UI.getCurrent().navigate(ExerciseView.class));	

		exercise = allExercises.get(0);
		
		H2 exerciseTitle = new H2(exercise.getTitle());
		
		Label exerciseShortDescrp = new Label(exercise.getShortDescription());

		/*
		 * button to start the exercise
		 */
		Button btnStart = new Button("Übung starten", new Icon(VaadinIcon.PLAY_CIRCLE_O));
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

		Button btnExit = new Button("Übung abbrechen", new Icon(VaadinIcon.CLOSE_SMALL), event -> {
			dlgExerciseDetail.close();
		});
		Button btnFinish = new Button("Übung erledigt", new Icon(VaadinIcon.CHECK), event -> {
			dlgExerciseDetail.close();
		});

		Label exerciseDetailDescrp = new Label(exercise.getDetailDescription());

		//lblExerciseDetail.append(lblExerciseDetail.getValue());
		HorizontalLayout layout = new HorizontalLayout(btnExit, btnFinish);
		dlgExerciseDetail.add(exerciseDetailDescrp, layout);

		dlgExerciseDetail.setWidth("400px");
		dlgExerciseDetail.setHeight("100px");

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
		rbgRating.setLabel("Auf einer Skala von 1 (schlecht) bis 5 (sehr gut): Wie sehr hat diese Übung dir geholfen?");
		
		dlgRating.setWidth("600px");
		dlgRating.setHeight("150px");

		Button btnOk = new Button("Speichern", event -> {
			presenter.saveRating(Integer.parseInt(rbgRating.getValue()), exercise.getId());
			
			dlgRating.close();
		});

		Button btnClose = new Button("Abbrechen", event -> {
			dlgRating.close();
		});
		HorizontalLayout layoutButtons = new HorizontalLayout(btnOk, btnClose);
		VerticalLayout layoutRating = new VerticalLayout(rbgRating);
		dlgRating.add(layoutRating, layoutButtons);
	}


}
