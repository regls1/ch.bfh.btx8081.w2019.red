package view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.red.SocialDisorderApp.MainView;


// WIRD BEARBEITET DURCH NEUES4!

@Route
public class ExerciseView extends VerticalLayout {

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

		Button ex1 = new Button("Atemübung");
		Button ex2 = new Button("Yoga");
		Button ex3 = new Button("Fremde Menschen ansprechen");

		ex1.addClickListener( e -> UI.getCurrent().navigate(ExerciseDetailView.class));
		ex2.addClickListener( e -> UI.getCurrent().navigate(ExerciseDetailView.class));
		ex3.addClickListener( e -> UI.getCurrent().navigate(ExerciseDetailView.class));

		exerciseBox.add(ex1, ex2, ex3);
		exerciseBox.setSizeFull();
		btnReturn.addClickListener( e -> UI.getCurrent().navigate(MainView.class));
		add(btnReturn, title, exerciseBox);	
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
	}
}	


