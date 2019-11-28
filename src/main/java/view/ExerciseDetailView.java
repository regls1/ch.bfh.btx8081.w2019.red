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
		btnReturn.addClickListener( e -> UI.getCurrent().navigate(ExerciseView.class));	

		/*
		 * title of the exercise
		 */
		H1 title = new H1("Atemübung");

		/*
		 * description of the exercise
		 */
		Label lblExerciseDescription = new Label("Diese Übung wird dir dabei helfen dich zu beruhigen.");
		/*
		 * button to start the exercise
		 */
		Button btnStart = new Button("Start", new Icon(VaadinIcon.PLAY_CIRCLE_O));
		btnStart.setIconAfterText(false);

		/*
		 * add the components to the view
		 */
		add(btnReturn, title, lblExerciseDescription, btnStart);

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

		Label lblExerciseDetail = new Label("Atme langsam und tief durch die Nase ein, bis sich Dein Bauch mit Luft gefüllt hat, und atme durch den Mund wieder aus. Versuche dabei die einströmende Luft in der Nase zu spüren und fühle, wie sich Deine Bauchdecke hebt und wieder senkt. Du kannst auch eine Hand auf Deinen Bauch legen, damit es Dir einfacher fällt, Dich auf das Heben und Senken Deines Bauches zu konzentrieren. Achte auf Deinen Atem und achte darauf, dass Du in das Zwerchfell oder den Bauch, anstatt in die Brust atmest. Konzentriere Dich so lange auf Deine Atmung, bis sich Deine Angst wieder gelegt hat und sich Dein Herzschlag verlangsamt. Wenn dies der Fall ist, klicke auf beenden.");
		HorizontalLayout layout = new HorizontalLayout(btnExit, btnFinish);
		dlgExerciseDetail.add(lblExerciseDetail, layout);

		dlgExerciseDetail.setWidth("400px");
		dlgExerciseDetail.setHeight("600px");

		btnStart.addClickListener(event -> dlgExerciseDetail.open());

		/*
		 * dialog to rate the exercise after finishing 
		 */
		Dialog dlgRating = new Dialog();
		btnFinish.addClickListener(event -> dlgRating.open());

		RadioButtonGroup<String> rbgRating = new RadioButtonGroup<>();
		rbgRating.setItems("5", "4", "3", "2", "1");
		rbgRating.setLabel("Mit wie vielen Sternen bewertest du diese Übung?");

		Button btnOk = new Button("OK", event -> {
			dlgRating.close();
		});
		Button btnClose = new Button("Abbrechen", event -> {
			dlgRating.close();
		});
		dlgRating.add(rbgRating, btnOk, btnClose);
	}
}
