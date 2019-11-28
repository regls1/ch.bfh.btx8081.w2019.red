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
 * This class shows every entry of the diary in a View.
 * 
 * @author Patricia
 *
 */
@SuppressWarnings("serial")
@Route
public class DiaryView extends VerticalLayout {

	private List<MockEntry> diaryEntryList = new ArrayList<MockEntry>();
	private Grid<MockEntry> grid = new Grid<>();
	private Button entryAddBtn = new Button("Neuer Eintrag");

	/**
	 * Constructor, creates a mock entry and sets the layout.
	 */
	public DiaryView() {

		// Add mock data in Grid.
		diaryEntryList.add(new MockEntry(1, "Hallo Welt!", "26.11.2019"));
		diaryEntryList.add(new MockEntry(2, "Familientreffen", "27.11.2019"));
		grid.setItems(diaryEntryList);

		// Set the name of the Header in Grid. A bug doesn't allow to set the Header
		// when its empty.
		grid.addColumn(MockEntry::getEntryNb).setHeader("Eintragsnummer");
		grid.addColumn(MockEntry::getTitel).setHeader("Titel");
		grid.addColumn(MockEntry::getDate).setHeader("Datum");

		// navigation to DiaryEntryView by Eye Icon or klick on Entry. Will later
		// navigate to a specific DiaryEntryView.
		grid.addComponentColumn(entry -> showDiaryEntryView(entry)).setHeader("Anzeigen");
		grid.addItemClickListener(e -> UI.getCurrent().navigate(DiaryEntryView.class));

		// Adds a delete Button in Grid.
		grid.addComponentColumn(entry -> deleteEntry(grid, entry)).setHeader("Löschen");
		grid.setWidthFull();

		// navigates to DiaryEntryView for Creating a new Entry.
		entryAddBtn.addClickListener(e -> UI.getCurrent().navigate(DiaryEntryView.class));

		// returnToHomescreen()
		Button returnButton = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		returnButton.addClickListener(e -> UI.getCurrent().navigate(MainView.class));

		// Layout
		add(returnButton, new H2("Tagebuch"), entryAddBtn, grid);

	}

	/**
	 * Deletes an Entry
	 * 
	 * @param grid, contains MockeEntries
	 * @param entry, a MockEntry
	 * @return Button with Trash Icon
	 */
	private Button deleteEntry(Grid<MockEntry> grid, MockEntry entry) {
		@SuppressWarnings("unchecked")
		Button TrashBtn = new Button(new Icon(VaadinIcon.TRASH), clickEvent -> {
			ListDataProvider<MockEntry> dataProvider = (ListDataProvider<MockEntry>) grid.getDataProvider();
			dataProvider.getItems().remove(entry);
			dataProvider.refreshAll();
		});
		return TrashBtn;
	}

	/**
	 * Navigates to the DiaryEntryView.
	 * @param entry, a MockEntry.
	 * @return Button with Eye Icon
	 */
	private Button showDiaryEntryView(MockEntry entry) {
		Button eyeBtn = new Button(new Icon(VaadinIcon.EYE));
		eyeBtn.addClickListener(event -> UI.getCurrent().navigate(DiaryEntryView.class));
		return eyeBtn;
	}

	

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

	// openEntryDetails(Entry) Implementing Method when connected to Database

}
