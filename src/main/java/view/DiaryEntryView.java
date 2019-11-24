package view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class DiaryEntryView extends VerticalLayout{
	
	public DiaryEntryView() {
		Button btnBack = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		btnBack.addClickListener(e -> UI.getCurrent().navigate(DiaryView.class));
		
		DatePicker date = new DatePicker();
		TextField txtTitle = new TextField("Titel");
		
		add(btnBack, new H1("Neuen Tagebucheintrag erstellen"), date, txtTitle);
	}

/*

	
	Datepicker
	RadioButtonGroup
	TextField txtTitle
	txtDescription TextArea
	imgMood Image
	imgActivity Image
	txtActitivityInfo TextField
	txtMoodInfo TextField
	moodList: ArrayList<Mood>
	activityList: ArrayList<Activity>
*/
	
	/* methods:
	 setPublic: void
	 setPrivate: void
	 openActivityDialog(): void
	 openMoodDialog(): void
	 saveEntry(): void
	 update: void()
	 
	 */
	
}
