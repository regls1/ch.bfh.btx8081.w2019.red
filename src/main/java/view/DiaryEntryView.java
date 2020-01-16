package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import presenter.DiaryPresenter;

/**
 * class that contains the view to add or edit an entry
 * 
 * @author khalife1, wackt2
 *
 */
@SuppressWarnings("serial")
@Route


public class DiaryEntryView extends VerticalLayout {

	ArrayList<String> activityList;
	Button btnBack;
	Button btnSave;
	CheckboxGroup<String> cbgActivities;
	DatePicker datePicker;
	HorizontalLayout moodLayout;
	Image imgHappy;
	Image imgSatisfied;
	Image imgNeutral;
	Image imgBad;
	Image imgAngry;
	RadioButtonGroup<String> rbgPrivacy;
	RadioButtonGroup<String> rbgMood;
	TextField txtTitle;
	TextArea txtDayDifficulty;
	TextArea txtDayPride;
	TextArea txtDaySymptom;
	TextArea txtAddition;
	DiaryPresenter presenter;

	public DiaryEntryView() throws ParseException {
		presenter = new DiaryPresenter();
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

		// textfield for title of diary entry
		txtTitle = new TextField("Titel");
		txtTitle.setWidth("100%");

		/*
		 * Symptome, Checkboxen inkl. Sonstiges -> Arraylist welche symptome
		 */

		// textarea for describing difficulty of the day
		txtDayDifficulty = new TextArea("Was fiel Dir heute besonders schwer?");
		txtDayDifficulty.setWidth("100%");
		txtDayDifficulty.getStyle().set("minHeight", "100px");

		// textarea for describing pride of the day
		txtDayPride = new TextArea("Auf was bist Du heute besonders stolz?");
		txtDayPride.setWidth("100%");
		txtDayPride.getStyle().set("minHeight", "100px");

		txtDaySymptom = new TextArea("Was hattest Du heute für Symptome?");
		txtDaySymptom.setWidth("100%");
		txtDaySymptom.getStyle().set("minHeight", "100px");

		// textarea for description
		txtAddition = new TextArea("Was möchtest Du zum heutigen Tag sonst noch sagen?");
		txtAddition.setWidth("100%");
		txtAddition.getStyle().set("minHeight", "175px");
		
		activityList = new ArrayList<String>();
		activityList.add("Schwimmen");
		activityList.add("Lesen");
		activityList.add("Fitness");
		activityList.add("Klettern");
		activityList.add("Konzert");
		activityList.add("Yoga");
		activityList.add("Wandern");

		// activities in checkboxes to choose from
		cbgActivities = new CheckboxGroup<String>();
		cbgActivities.setItems(activityList);

		// horizontal layout for mood buttons
		moodLayout = new HorizontalLayout();
		

		// radiobuttongroup to set mood levels
		rbgMood = new RadioButtonGroup<>();
		rbgMood.setItems("glücklich", "zufrieden", "neutral", "schlecht", "wütend");
		rbgMood.setValue("glücklich");
		

		// images that contain the mood levels
		imgHappy = new Image("./img/Sehr gut.png", "sehr gut");
		imgHappy.setWidth("80px");
		imgSatisfied = new Image("./img/gut.png", "gut");
		imgSatisfied.setWidth("88px");
		imgNeutral = new Image("./img/normal.png", "normal");
		imgNeutral.setWidth("88px");
		imgBad = new Image("./img/schlecht.png", "schlecht");
		imgBad.setWidth("88px");
		imgAngry = new Image("./img/sehr schlecht.png", "sehr schlecht");
		imgAngry.setWidth("88px");

		// add all buttons to horizontal layout
		
		moodLayout.add(imgHappy, imgSatisfied, imgNeutral, imgBad, imgAngry);
		

		// radiobuttongroup to set entry private or public with standard value private
		rbgPrivacy = new RadioButtonGroup<>();
		rbgPrivacy.setLabel("Freigabe");
		rbgPrivacy.setItems("privat", "öffentlich");
		rbgPrivacy.setValue("privat");

		// button to save current entry
		btnSave = new Button("Speichern", new Icon(VaadinIcon.SAFE));
		
		boolean privacy;
		if(rbgPrivacy.getValue().equals("privat")) {
			privacy = true;
		} else {
			privacy = false;
		}
		
		btnSave.addClickListener(e -> {
			UI.getCurrent().navigate(DiaryView.class);
			try {
				presenter.addEntry(txtTitle.getValue(), new SimpleDateFormat("yyyy-dd-MM").parse(datePicker.getValue().toString()), txtDayDifficulty.getValue(), 
						txtDayPride.getValue(), txtAddition.getValue(), privacy, presenter.getMoodId(rbgMood.getValue()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
		});
		
		// add all components to the vertical layout of the view
		add(btnBack, new H3("Neuen Tagebucheintrag erstellen"), datePicker, txtTitle, txtDayDifficulty, txtDayPride,
				txtDaySymptom, txtAddition, new Label("Was hast Du für Aktivitäten an diesem Tag gemacht?"),
				cbgActivities, new Label("Wie war Deine Stimmung an diesem Tag?"),moodLayout, rbgMood,  rbgPrivacy,
				btnSave);
	}

	public void saveEntry() {
		
	}

	public void update() {

	}
}
