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
public class DiaryTest {

	private DiaryPresenter presenter = new DiaryPresenter();
	private DiaryService service = new DiaryService();
	
	/**
	 * method to get id of an existing entry
	 * @param date, date of an entry
	 * @return id of entry
	 */
	public int getEntryID(String title) {
		int id = 0;
		for (Entry entry : service.getAllEntries()) {
			if (entry.getTitle().equals(title)) {
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
		Entry entry = new Entry();
		entry.setTitle("Neuer Eintrag");
		entry.setDate(date);
		entry.setDifficulty("Nervös wegen Ansprechen");
		entry.setPride("Habe trotzdem jemanden angesprochen");
		entry.setAdditional("-");
		entry.setPrivacy(true);
		entry.setMoodId(1);
		presenter.addEntry("Neuer Eintrag", date, "Nervös wegen Ansprechen", "Habe trotzdem jemanden angesprochen", "-", true, 1);
		assertTrue(presenter.checkEntry(entry));
	}
	
	@Test
	/**
	 * method that tests if it is possible to access an entry from database
	 */
	public void getEntry() {
		int id = this.getEntryID("Neuer Eintrag");
		Entry entry = presenter.getEntry(id);
		assertEquals(entry.getDifficulty(), "Nervös wegen Ansprechen");
	}
	
	@Test
	/**
	 * method that tests if an existing entry can be deleted in database
	 */
	public void deleteEntry() throws ParseException {
		int id = this.getEntryID("Neuer Eintrag");
		Entry entry = presenter.getEntry(id);
		presenter.deleteEntry(id);
		assertFalse(entry.getAdditional().equals("additional"));
	}
}
