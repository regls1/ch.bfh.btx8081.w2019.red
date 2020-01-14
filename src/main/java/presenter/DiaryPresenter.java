package presenter;

import java.util.List;

import model.Entry;
import service.DiaryService;
import view.DiaryView;

/**
 * Presenter for Diary Entries.
 * @author romap1
 *
 */
public class DiaryPresenter {
	
	private DiaryService ds = new DiaryService();

	
	/**
	 * Returns List with all Entries from the database.
	 * @return List with all Entries
	 */
	public List<Entry> getAllEntries() {
		return ds.getAllEntries();
		
	}
	/**
	 * Deletes a Entry.
	 * @param entry, is a Diary entry 
	 */
	public void deleteEntry(Entry entry) {
		ds.deleteEntry(entry.getId());
		
	}

	
	
}
