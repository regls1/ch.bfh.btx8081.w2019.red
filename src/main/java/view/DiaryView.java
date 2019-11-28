package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.red.SocialDisorderApp.MainView;

/**
 * PLEASE contact me if you want to change something in this class.
 * 
 * @author Patricia
 *
 */
@SuppressWarnings("serial")
@Route
public class DiaryView extends VerticalLayout {

	private List<MockEntry> diaryEntryList = new ArrayList<MockEntry>();
	private Grid<MockEntry> grid = new Grid<>();
	private Button entryAddButton = new Button("Neuer Eintrag");

	/**
	 * Constructor, creates a mock entry and sets the layout.
	 */
	public DiaryView() {

		// Add mock data in Grid.
		diaryEntryList.add(new MockEntry(1, "Hallo Welt!", "01.01.1999"));
		diaryEntryList.add(new MockEntry(2, "dasdf", "12314"));
		grid.setItems(diaryEntryList);

		// Set the name of the Header in Grid. A bug doesn't allow to set the Header
		// when its empty.
		grid.addColumn(MockEntry::getEntryNb).setHeader("Eintragsnummer");
		grid.addColumn(MockEntry::getTitel).setHeader("Titel");
		grid.addColumn(MockEntry::getDate).setHeader("Datum");

		// Adds a delete Button
		grid.addComponentColumn(item -> deleteEntry(grid, item)).setHeader("Löschen");
		grid.setWidthFull();

		// navigates to DiaryEntryView. Will later navigate to a specific
		// DiaryEntryView.
		grid.addItemClickListener(e -> UI.getCurrent().navigate(DiaryEntryView.class));

		// navigates to DiaryEntryView for Creating a new Entry.
		entryAddButton.addClickListener(e -> UI.getCurrent().navigate(DiaryEntryView.class));

		// returnToHomescreen()
		Button returnButton = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));

		// returnButton.setIconAfterText(false);
		returnButton.addClickListener(e -> UI.getCurrent().navigate(MainView.class));

		// Layout
		add(returnButton, new H2("Tagebuch"), entryAddButton, grid);

	}

	
	/**
	 * 
	 * @param grid
	 * @param item
	 * @return
	 */
	private Button deleteEntry(Grid<MockEntry> grid, MockEntry item) {
		@SuppressWarnings("unchecked")
		Button button = new Button("Löschen", clickEvent -> {
			ListDataProvider<MockEntry> dataProvider = (ListDataProvider<MockEntry>) grid.getDataProvider();
			dataProvider.getItems().remove(item);
			dataProvider.refreshAll();
		});
		return button;
	}

	/**
	 * trying how to add a mockEntry into the Grid.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private Component test() {
		entryAddButton.addClickListener(null);
		return entryAddButton;

	}

	// openEntryDetails(Entry)
	// addEntry()

	/**
	 * Mock Entry Class for setting Header of Grid
	 * 
	 * @author Patricia
	 *
	 */
	public class MockEntry {

		private String date;;
		private int entryNb;
		private String titel;

		public MockEntry(int entryNb, String titel, String d) {
			this.entryNb = entryNb;
			this.titel = titel;
			date = d;

		}

		public String getTitel() {
			return titel;
		}

		public void setTitel(String titel) {
			this.titel = titel;
		}

		public int getEntryNb() {
			return entryNb;
		}

		public void setEntryNb(int entryNb) {
			this.entryNb = entryNb;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}
	}

	/*
	 * Please comment if you change something in this class.
	 */
	// public DiaryView() {
	// add(new H1("Bla bla bla bla"));
	// }
	// Button button = new Button("Hello", event -> Notification.show("Clicked!"));
}
