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
	Button ok;
	Button close;
	Button ok1;
	Button close1;
	CheckboxGroup<String> activites;
	Button btnSave;
	HorizontalLayout footerMood;
	HorizontalLayout footerAct;
	
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
		ok1 = new Button("OK");
		close1 = new Button("Abbrechen");
		close1.addClickListener(event -> dlgActivity.close());
		footerAct = new HorizontalLayout(ok1,close1);
		
		// dialog for choosing an activities
		dlgActivity = new Dialog();
		dlgActivity.add(activites, footerAct);
		dlgActivity.setWidth("500px");
		dlgActivity.setHeight("150px");
		
		// button for opening dialog to choose current mood
		btnMood = new Button("Stimmung");
		btnMood.addClickListener(e -> dlgMood.open());
		
		// radiobuttongroup with different moods
		rbgMood = new RadioButtonGroup<>();
		rbgMood.setItems("Sehr gut", "Gut", "mittelmässig", "schlecht", "sehr schlecht");
		rbgMood.setLabel("Mood today");
		ok = new Button("OK");
		close = new Button("Abbrechen");
		close.addClickListener(event -> dlgMood.close());
		footerMood = new HorizontalLayout(ok,close);
		
		
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
