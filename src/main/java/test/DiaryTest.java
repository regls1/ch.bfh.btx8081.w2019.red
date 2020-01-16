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
	
	/**
	 * method to get id of an existing entry
	 * @param date, date of an entry
	 * @return id of entry
	 */
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
	/**
	 * method that tests if an entry can be added
	 */
	public void addEntry() throws ParseException {
		String sDate = "30.05.2020";
		Date date = new SimpleDateFormat("dd.MM.yyyy").parse(sDate);
		Entry entry = new Entry(666, "Neuer Eintrag", date, "Nervös wegen Ansprechen", "Habe trotzdem jemanden angesprochen", "-", true);
		presenter.addEntry(666, "Neuer Eintrag", date, "Nervös wegen Ansprechen", "Habe trotzdem jemanden angesprochen", "-", true);
		assertTrue(presenter.checkEntry(entry));
	}
	
	@Test
	/**
	 * method that tests if it is possible to access an entry from database
	 */
	public void getEntry() throws ParseException {
		String sDate = "30.05.2020";
		Date date = new SimpleDateFormat("dd.MM.yyyy").parse(sDate);
		int id = this.getEntryID(date);
		Entry entry = presenter.getEntry(id);
		assertEquals(entry.getAdditional(), "additional");
		assertEquals(entry.getPride(), "pride");
	}
	
	@Test
	/**
	 * method that tests if an existing entry can be deleted in database
	 */
	public void deleteEntry() throws ParseException {
		String sDate = "30.05.2020";
		Date date = new SimpleDateFormat("dd.MM.yyyy").parse(sDate);
		int id = this.getEntryID(date);
		Entry entry = presenter.getEntry(id);
		presenter.deleteEntry(id);
		assertFalse(entry.getAdditional().equals("additional"));
	}
}
