package view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class ContactView extends VerticalLayout {

	public ContactView() {
		add(new H1("I am a sample contact view"));
	}
}