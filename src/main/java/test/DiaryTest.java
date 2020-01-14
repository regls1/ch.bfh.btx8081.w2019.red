package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import model.Entry;
import presenter.DiaryPresenter;
import service.DiaryService;

/** 
 * junit test to test diary
 * @author wackt2
 *
 */

class DiaryTest {

	private DiaryPresenter presenter = new DiaryPresenter();
	private DiaryService service = new DiaryService();
	
	public int getEntryID(Date date) {
		int id = 0;
		for (Entry entry : service.getAllEntries()) {
			if (entry.getDate().equals(date)) {
				id = entry.getId();
			}
		}
		return id;
	}
	
	@Test
	public void addEntry() {
		//presenter.save...(...);
		//assertTrue(presenter...(...));
	}
	
	@Test
	public void getEntry() throws ParseException {
		//String sDate = "30.05.2020";
		//Date date = new SimpleDateFormat("dd.MM.yyyy").parse(sDate);
		//int id = this.getEntryID(date);
		//Entry entry = presenter.getEntry(id);
		//assertEquals(...);
		//assertEquals(...);
	}
	
	@Test
	public void deleteEntry() {
		//String sDate = "30.05.2020";
		//Date date = new SimpleDateFormat("dd.MM.yyyy").parse(sDate);
		//int id = this.getEntryID(date);
		//Entry entry = presenter.getEntry(id);
		//presenter.delete...(id);
		//assertFalse(...);
	}
}
