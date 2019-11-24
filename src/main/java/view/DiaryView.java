package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
/**
 * PLEASE contact me if you want to change something in this class.
 * @author Patricia
 *
 */
@Route
public class DiaryView extends VerticalLayout {

	// private List<Object> entries = new ArrayList();
	private Grid<MockEntry> grid = new Grid<>();
	private Button entryAddButton = new Button("Create new Entry");

	
/**
 * Mock Entry Class for setting Header of Grid
 * @author Patricia
 *
 */
	public class MockEntry {

		private String date;;
		private int entryNb;
		

		public int getEntryNb() {
			return entryNb;
		}

		public void setEntryNb(int entryNb) {
			this.entryNb = entryNb;
		}

		public MockEntry(String d, int entryNb) {
			date = d;
			this.entryNb = entryNb;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}
	}

/**
 * Constructor, creates a mock entry  and sets the layout.
 */
	public DiaryView() {
		MockEntry mockEntry = new MockEntry("datum", 1);
		
		grid.addColumn(MockEntry::getDate).setHeader("Date");
		grid.addColumn(MockEntry::getEntryNb).setHeader("Entry Number");
		
		add(new H1("DiaryView"), entryAddButton, grid);
		// gridtest.setItems(entries);
		// for (int i=1; i < 5; i++) {
		// entries.add("test" + i);
		// }

	}
/**
 * trying how to add a mockEntry into the Grid.
 * @return
 */
	private Component test() {
		entryAddButton.addClickListener(null);
		return entryAddButton;

	}

	
	
	/*
	 * Please comment if you change something in this class.
	 */
	// public DiaryView() {
	// add(new H1("Bla bla bla bla"));
	// }
	// Button button = new Button("Hello", event -> Notification.show("Clicked!"));
}
