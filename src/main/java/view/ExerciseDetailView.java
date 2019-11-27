package view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.red.SocialDisorderApp.MainView;


/**
 * A class which contains the details of the exercises
 * 
 * @author neues4
 *
 */
@SuppressWarnings("serial")
@Route
public class ExerciseDetailView extends VerticalLayout {

	/*
	 * constructor
	 */
	public ExerciseDetailView() {

		/*
		 * return button
		 */
		Button btnReturn = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		btnReturn.setIconAfterText(false);
		btnReturn.addClickListener( e -> UI.getCurrent().navigate(MainView.class));	

		/*
		 * title of the exercise
		 */
		H1 title = new H1("Hier wird der Übungstitel stehen");

		/*
		 * description of the exercise
		 */
		Label exerciseDescription = new Label("Hier wird eine Anleitung für die Übung stehen");

		/*
		 * button to start the exercise
		 */
		Button btnStart = new Button("Start", new Icon(VaadinIcon.PLAY_CIRCLE_O));
		btnStart.setIconAfterText(false);

		/*
		 * add the components to the view
		 */
		add(btnReturn, title, exerciseDescription, btnStart);

		/*
		 * create a new dialog to show further information of the exercise
		 * "abbrechen" to go back to the exercise detail view,
		 * "beenden" to finish the exercise
		 */
		Dialog exerciseDetail = new Dialog();
	
		Button btnExit = new Button("Abbrechen", event -> {
			exerciseDetail.close();
		});
		Button btnFinish = new Button("Beenden", event -> {
			exerciseDetail.close();
		});

		Label label = new Label("Hier stehen weiere Informationen, die dem User bei der Durchführung helfen");
		HorizontalLayout layout = new HorizontalLayout(btnExit, btnFinish);
		exerciseDetail.add(label, layout);

		exerciseDetail.setWidth("400px");
		exerciseDetail.setHeight("600px");

		btnStart.addClickListener(event -> exerciseDetail.open());

		/*
		 * dialog to rate the exercise after finishing 
		 */
		Dialog rating = new Dialog();
		btnFinish.addClickListener(event -> rating.open());

		RadioButtonGroup<String> rbgRating = new RadioButtonGroup<>();
		rbgRating.setItems("5", "4", "3", "2", "1");
		rbgRating.setLabel("Mit wie vielen Sternen bewertest du diese Übung?");

		Button btnOk = new Button("OK", event -> {
			rating.close();
		});
		Button btnClose = new Button("Abbrechen", event -> {
			rating.close();
		});
		rating.add(rbgRating, btnOk, btnClose);
	}
}
