package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.html.Div;
//Klasse wird von romap1 bearbeitet.
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class DiaryView extends VerticalLayout {

	// private List<Object> entries = new ArrayList();
	private Grid<DiaryView> gridtest = new Grid<>();
	private Button entryAddButton = new Button("Create new Entry");

	/**
	 * Constructor
	 */
	public DiaryView() {
		 
//gridtest.setColumns("date"," Nr");
//gridtest.addColumn("Date2");
		add(new H1("DiaryView"), entryAddButton, gridtest);
		// gridtest.setItems(entries);
		// for (int i=1; i < 5; i++) {
		// entries.add("test" + i);
		// }

	}

	
	private Component test() {
		entryAddButton.addClickListener(null);
		return entryAddButton;
		
	}

	// public DiaryView() {
	// add(new H1("Bla bla bla bla"));
	// }
	// Button button = new Button("Hello", event -> Notification.show("Clicked!"));
}
