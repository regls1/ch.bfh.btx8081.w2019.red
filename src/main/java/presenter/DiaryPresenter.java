package presenter;

import java.util.List;

import model.Entry;
import service.DiaryService;
import view.DiaryView;

public class DiaryPresenter {
	
	private DiaryService ds = new DiaryService();

	
	
	public List<Entry> getAllEntries() {
		return ds.getAllEntries();
		
	}
	
	public void deleteEntry(Entry entry) {
		ds.deleteEntry(entry.getId());
		
	}

	
	
}
