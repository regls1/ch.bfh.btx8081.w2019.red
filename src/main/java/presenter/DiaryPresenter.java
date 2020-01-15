package presenter;

import java.util.Date;
import java.util.List;

import model.Activity;
import model.Entry;
import model.Mood;
import model.Symptom;
import service.DiaryService;

/**
 * Presenter for Diary Entries.
 * 
 * @author romap1
 *
 */
public class DiaryPresenter {

	private DiaryService ds = new DiaryService();

	/**
	 * Returns List with all Entries from the database.
	 * 
	 * @return List with all Entries
	 */
	public List<Entry> getAllEntries() {
		return ds.getAllEntries();

	}

	
	/**
	 * Gets Entry
	 * 
	 * @param entry
	 * @return Entry
	 */
	public Entry getEntry(Entry entry) {
		return ds.getEntry(entry.getId());

	}

	
	/**
	 * Deletes Entry
	 * 
	 * @param entry
	 */
	public void deleteEntry(Entry entry) {
		ds.deleteEntry(entry.getId());

	}

	
	/**
	 * Updates Entry
	 * 
	 * @param entry
	 */
	public void updateEntry(Entry entry) {
		ds.updateEntry(entry.getId(), entry);
	}

	
	/**
	 * Adds Entry
	 */
	public void addEntry(int id, String title, Date date, String difficulty, String pride, String additional,
			Boolean privacy) {
		Entry entry = new Entry(id, title, date, difficulty, pride, additional, privacy);
		ds.addEntry(entry);
	}

	
	/**
	 * Gets Mood
	 * 
	 * @param entry
	 * @return Mood
	 */
	public Mood getMood(Entry entry) {
		return ds.getMood(entry.getMoodId());

	}

	
	/*
	 * Added as soon DiaryEntryView works.
	 * 
	 * public void updateMood(Mood mood, String name) {
	 * 
	 * }
	 */

	
	/**
	 * Adds Mood
	 * 
	 * @param mood
	 */
	public void addMood(Mood mood) {
		ds.addMood(mood);
	}

	
	/**
	 * Deletes Mood
	 * 
	 * @param entry
	 */
	public void deleteMood(Entry entry) {
		ds.deleteMood(entry.getMoodId());
	}

	
	/**
	 * Get Symptom
	 * 
	 * @param id
	 * @return Symptom
	 */
	public Symptom getSymptom(int id) {
		return ds.getSymptom(id);
	}

	
	/*
	 * Added as soon DiaryEntryView works. public void updateSymptom(Symptom
	 * symptom) {
	 * 
	 * }
	 */

	
	/**
	 * Adds Symptom
	 * 
	 * @param symptom
	 */
	public void addSymptom(Symptom symptom) {
		ds.addSymptom(symptom);
	}

	
	/**
	 * Deletes Symptom
	 * 
	 * @param symptom
	 */
	public void deleteSymptom(Symptom symptom) {
		ds.deleteSymptom(symptom.getId());
	}

	
	/**
	 * Gets Activity
	 * 
	 * @param id
	 * @return Activity
	 */
	public Activity getActivity(int id) {
		return ds.getActivity(id);
	}

	
	/**
	 * Adds Activity
	 * 
	 * @param activity
	 */
	public void addActivity(Activity activity) {
		ds.addActivity(activity);
	}

	
	/**
	 * Deletes Activity
	 * 
	 * @param activity
	 */
	public void deleteActivity(Activity activity) {
		ds.deleteActivity(activity.getId());
	}

}
