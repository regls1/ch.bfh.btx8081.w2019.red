package view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

//WIRD BEARBEITET DURCH NEUES4!

@Route
public class ExerciseDetailView extends VerticalLayout {
	
	public ExerciseDetailView() {
		add(new H1("I am a sample exercise detail view"));
	}
	
}
