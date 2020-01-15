package view;


import java.util.Date;
import java.util.List;
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
import model.Entry;
import presenter.DiaryPresenter;
import service.DiaryService;

/**
 * 
 * This class shows every entry of the diary in a View.
 * 
 * @author romap1
 *
 */
@SuppressWarnings("serial")
@Route
public class DiaryView extends VerticalLayout {

	
	private Grid<Entry> grid = new Grid<>();
	private Button entryAddBtn = new Button("Neuer Eintrag");
	private DiaryPresenter presenter = new DiaryPresenter();
	
	/**
	 * Constructor, creates a mock entry and sets the layout.
	 */
	public DiaryView() {

		
		//Creates Mock Entries, is used as long Entries cant get added with DiaryEntryView to database.
		DiaryService ds = new DiaryService();
		Entry testEntry = new Entry (1,"juhu!", new Date());
		ds.addEntry(testEntry);
		
		List<Entry> allEntries=	presenter.getAllEntries();
		grid.setItems(allEntries);

		// Set the name of the Header in Grid. A bug doesn't allow to set the Header
		// when its empty.
		grid.addColumn(Entry::getId).setHeader("Eintragsnummer");
		grid.addColumn(Entry::getTitle).setHeader("Titel");
		grid.addColumn(Entry::getDate).setHeader("Datum");

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
	 * @param grid, contains Entries
	 * @param entry, a Entry
	 * @return Button with Trash Icon
	 */
	private Button deleteEntry(Grid<Entry> grid, Entry entry) {
		@SuppressWarnings("unchecked")
		Button TrashBtn = new Button(new Icon(VaadinIcon.TRASH), clickEvent -> {
			ListDataProvider<Entry> dataProvider = (ListDataProvider<Entry>) grid.getDataProvider();
			dataProvider.getItems().remove(entry);
			dataProvider.refreshAll();
			//braucht noch try catch klausel mit ExceptonHandling
		presenter.deleteEntry(entry);
		});
		return TrashBtn;
	}

	/**
	 * Navigates to the EntryView.
	 * @param entry, a Entry.
	 * @return Button with Eye Icon
	 */
	private Button showDiaryEntryView(Entry entry) {
		Button eyeBtn = new Button(new Icon(VaadinIcon.EYE));
		eyeBtn.addClickListener(event -> UI.getCurrent().navigate(DiaryEntryView.class));
		return eyeBtn;
	}

	

	/**
	 * Mock Entry Class for setting Header of Grid. Deprecated. Use Entry instead.
	 * 
	 * @author romap1
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

}
