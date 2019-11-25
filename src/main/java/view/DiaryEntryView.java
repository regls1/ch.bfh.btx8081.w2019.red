package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@Route
public class DiaryEntryView extends VerticalLayout{
	
	Button btnBack;
	DatePicker datePicker;
	TextField txtTitle;
	TextArea txtDescription;
	Button btnActivity;
	Button btnMood;
	RadioButtonGroup<String> rbgPrivacy;
	Dialog dlgActivity;
	Dialog dlgMood;
	RadioButtonGroup<String> rbgMood;
	Button message;
	Button btnOkActivityDialog;
	Button btnCloseActivityDialog;
	Button btnOkMoodDialog;
	Button btnCloseMoodDialog;
	CheckboxGroup<String> activites;
	Button btnSave;
	HorizontalLayout footerMood;
	HorizontalLayout footerAct;
	HorizontalLayout moodButton;
	Button sehrGut;
	Button gut;
	Button normal;
	Button schelcht;
	Button sehrSchlecht;
	
	
	public DiaryEntryView() {
		// button for returning to diary page
		btnBack = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		btnBack.addClickListener(e -> UI.getCurrent().navigate(DiaryView.class));
		
		// datepicker for choosing a date with standard value of current date
		LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		datePicker = new DatePicker("Datum");
		datePicker.setWidth("100%");
		datePicker.setPlaceholder(dateFormatter.format(currentDate));
		datePicker.setClearButtonVisible(true);
		datePicker.setLocale(Locale.GERMAN);
		
		// textfield for title
		txtTitle = new TextField("Titel");
		txtTitle.setWidth("100%");
		
		// textarea for description
		txtDescription = new TextArea("Beschreibung");
		txtDescription.setWidth("100%");
		txtDescription.getStyle().set("minHeight", "200px");
		
		// radiobuttongroup to set entry private or public with standard value private
		rbgPrivacy = new RadioButtonGroup<>();
		rbgPrivacy.setLabel("Freigabe");
		rbgPrivacy.setItems("privat", "öffentlich");
		rbgPrivacy.setValue("privat");
		
		// button for opening dialog to choose activities
		btnActivity = new Button("Aktivitäten");
		btnActivity.addClickListener(e -> dlgActivity.open());
		
		activites = new CheckboxGroup<String>();
		activites.setLabel("Activites");
		activites.setItems("Schwimmen","Lesen","Fitness","Klettern","Tanzen","Tischtenis","Minigolf","Yoga","Wandern","Treffen");
		btnOkActivityDialog = new Button("OK");
		btnCloseActivityDialog = new Button("Abbrechen");
		btnCloseActivityDialog.addClickListener(event -> dlgActivity.close());
		footerAct = new HorizontalLayout(btnOkActivityDialog,btnCloseActivityDialog);
		
		// dialog for choosing an activities
		dlgActivity = new Dialog();
		dlgActivity.add(activites, footerAct);
		dlgActivity.setWidth("500px");
		dlgActivity.setHeight("150px");
		
		// button for opening dialog to choose current mood
		btnMood = new Button("Stimmung");
		btnMood.addClickListener(e -> dlgMood.open());
		
		sehrGut = new Button(new Image("./img/Sehr gut.png", "Sehr Gut"));
		gut = new Button(new Image("./img/gut.png", "Gut"));
		normal = new Button(new Image("./img/normal.png", "normal"));
		schelcht = new Button(new Image("./img/schlecht.png", "schlecht"));
		sehrSchlecht = new Button(new Image("./img/sehr schlecht.png", "sehr schlecht"));
		moodButton = new HorizontalLayout();
		moodButton.add(sehrGut,gut,normal,schelcht,sehrSchlecht);
		
		
		// radiobuttongroup with different moods
		rbgMood = new RadioButtonGroup<>();
		rbgMood.add(moodButton);
		rbgMood.setLabel("Mood today");
		btnOkMoodDialog = new Button("OK");
		btnCloseMoodDialog = new Button("Abbrechen");
		btnCloseMoodDialog.addClickListener(event -> dlgMood.close());
		footerMood = new HorizontalLayout(btnOkMoodDialog,btnCloseMoodDialog);
		
		
		// dialog for choosing current
		dlgMood = new Dialog();
		
		dlgMood.add(rbgMood, footerMood);
		dlgMood.setWidth("500px");
		dlgMood.setHeight("150px");
		
		// button to save current entry
		btnSave = new Button("Speichern", new Icon(VaadinIcon.DISC));
		btnSave.addClickListener(e -> saveEntry());
		
		// add all components to the vertical layout of the view
		add(btnBack, new H3("Neuen Tagebucheintrag erstellen"), datePicker, txtTitle, txtDescription, btnActivity, 
				btnMood, rbgPrivacy, dlgActivity, dlgMood, btnSave);
	}
	
	/*
	public void setPublic() {
		if(rbgPrivacy.getValue().equals("öffentlich")) {
			
		}
	}
	
	public void setPrivate() {
		if(rbgPrivacy.getValue().equals("privat")) {
			
		}
	}
	*/
	
	public void saveEntry() {
		
	}

	public void update() {
		
	}
}
