package view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

// WIRD BEARBEITET DURCH NEUES4!

@Route
public class ExerciseView extends VerticalLayout {

	public ExerciseView() {
		add(new H1("I am a sample exercise view"));
	}
}



