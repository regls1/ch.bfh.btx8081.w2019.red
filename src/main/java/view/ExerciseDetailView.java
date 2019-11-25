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

//WIRD BEARBEITET DURCH NEUES4!

@SuppressWarnings("serial")
@Route
public class ExerciseDetailView extends VerticalLayout {

	public ExerciseDetailView() {

		Button btnReturn = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		btnReturn.setIconAfterText(false);

		btnReturn.addClickListener( e -> UI.getCurrent().navigate(MainView.class));	

		H1 title = new H1("Hier wird der Übungstitel stehen");

		Label exerciseDescription = new Label("Hier wird eine Anleitung für die Übung stehen");

		Button btnStart = new Button("Start", new Icon(VaadinIcon.PLAY_CIRCLE_O));
		btnStart.setIconAfterText(false);

		add(btnReturn, title, exerciseDescription, btnStart);

		Dialog exerciseDetail = new Dialog();
		// exerciseDetail.add(new Label("Hier stehen weitere Informationen, die dem User bei der Durchführung helfen."));

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

		Dialog rating = new Dialog();
		btnFinish.addClickListener(event -> rating.open());

		// Label lblRating = new Label("Wie hat dir diese Übung geholfen?");
		// rating.add(lblRating);

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
