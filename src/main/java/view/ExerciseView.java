package view;

import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ch.bfh.btx8081.w2019.red.SocialDisorderApp.MainView;
import model.Exercise;
import service.ExerciseService;

/**
 * A view which contains all the exercises as buttons and opens a new dialog if a button is clicked.
 * This dialog shows further information needed to do the exercise.
 * After the exercise is done, it can be rated in a new dialog.
 * 
 * @author neues4
 *
 */
@SuppressWarnings("serial")
@Route
public class ExerciseView extends VerticalLayout {

	// create new exercise service
	ExerciseService exsc = new ExerciseService();

	// exercise service reads all contacts from database and saves them into a list
	List<Exercise> allExercises = exsc.getAllExercises();

	/*
	 * create new list box with buttons
	 */
	ListBox<Button> exerciseBox = new ListBox<>();

	/*
	 * constructor which sets the title, the return button, and a button for each exercise
	 */
	public ExerciseView() {

		H1 title = new H1("Übungen");

		Button btnReturn = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		btnReturn.setIconAfterText(false);
		btnReturn.addClickListener( e -> UI.getCurrent().navigate(MainView.class));

		ListBox<Button> boxExerciseTitle = new ListBox<Button>();
		boxExerciseTitle.setSizeFull();

		// loop through exercise list and create buttons. create a dialog which shows the right exercise
		for(Exercise exercise : allExercises) {
			Button bt = new Button(exercise.getTitle());
			boxExerciseTitle.add(bt);
			//bt.addClickListener(event -> createDialog(exercise.getId()).open());
			if (exercise.getId() == 1) {
			bt.addClickListener(event -> UI.getCurrent().navigate(ExerciseDetailView1.class));
			}
			else if (exercise.getId() == 2) {
				bt.addClickListener(event -> UI.getCurrent().navigate(ExerciseDetailView2.class));
			}
			else if (exercise.getId() == 3) {
				bt.addClickListener(event -> UI.getCurrent().navigate(ExerciseDetailView3.class));
			}
			else if (exercise.getId() == 4) {
				bt.addClickListener(event -> UI.getCurrent().navigate(ExerciseDetailView4.class));
			}
			/*
			else if (exercise.getId() == 5) {
				bt.addClickListener(event -> UI.getCurrent().navigate(ExerciseDetailView5.class));
			}
			else if (exercise.getId() == 6) {
				bt.addClickListener(event -> UI.getCurrent().navigate(ExerciseDetailView6.class));
			}
			else if (exercise.getId() == 7) {
				bt.addClickListener(event -> UI.getCurrent().navigate(ExerciseDetailView7.class));
			}
			else if (exercise.getId() == 8) {
				bt.addClickListener(event -> UI.getCurrent().navigate(ExerciseDetailView8.class));
			}
			*/
		}
		// add the return button, the title and the ListBox to the view
		add(btnReturn, title, boxExerciseTitle);
	}
}