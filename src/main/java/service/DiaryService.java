package service;

import java.util.List;
import model.Activity;
import model.Entry;
import model.Mood;
import model.Symptom;

/**
 * Service class for Diary, knows the database. 
 * @author romap1
 *
 */
public class DiaryService {
	
	
	/**
	 * Gets the User with the given ID.
	 * @param id
	 * @return the found User instance or null if the entity does not exist.
	 */
	public Entry getEntry(int id) {
		return EntityService.em.find(Entry.class, id);
		
	}

	/**
	 * Gets a ArrayList with all Entries.
	 * @return the ArrayList with all Entry instance.
	 */
	@SuppressWarnings("unchecked")
	public List<Entry> getAllEntries() {
		return (List<Entry>)EntityService.em.createQuery("select e from Entry e").getResultList();
	}
	
	/**
	 * Updates Entry with the given ID.
	 * @param id
	 * @param entry
	 * @return the Entry.
	 */
	public Entry updateEntry(int id, Entry entry) {
		EntityService.em.getTransaction().begin();
		
		Entry e = EntityService.em.find(Entry.class, id);
		
		e.setTitle(entry.getTitle());
		e.setPrivacy(entry.getPrivacy());
		e.setPride(entry.getPride());
		e.setDifficulty(entry.getDifficulty());
		e.setDate(entry.getDate());
		e.setAdditional(entry.getAdditional());
		
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return e;
	}
	
	
	/**
	 * Adds Entry.
	 * @param entry
	 * @return the new Entry.
	 */
	public Entry addEntry(Entry entry) {
		EntityService.em.getTransaction().begin();
		
		Entry e = new Entry();
		
		e.setTitle(entry.getTitle());
		e.setPrivacy(entry.getPrivacy());
		e.setPride(entry.getPride());
		e.setDifficulty(entry.getDifficulty());
		e.setDate(entry.getDate());
		e.setAdditional(entry.getAdditional());
		
		EntityService.em.persist(e);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return e;
	}	
	
	/**
	 * Deletes Entry with the given ID.
	 * @param id
	 */
	public void deleteEntry(int id) {
		Entry e = EntityService.em.find(Entry.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(e);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
	}
	
	
	/**
	 * Gets Mood with the given ID.
	 * @param id
	 * @return the found Mood instance or null if the entity does not exist.
	 */
	public Mood getMood(int id) {
		return EntityService.em.find(Mood.class, id);
		
	}
	
	/**
	 * Updates the mood with a given ID
	 * @param id
	 * @param mood
	 * @return the mood
	 */
	public Mood updateMood(int id, Mood mood) {
		EntityService.em.getTransaction().begin();
		
		Mood m = EntityService.em.find(Mood.class, id);
		
		m.setName(mood.getName());
		
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return m;
	}
	
	
	/**
	 * Adds a Mood. 
	 * @param mood
	 * @return the new Mood.
	 */
	public Mood addMood(Mood mood) {
		EntityService.em.getTransaction().begin();
		
		Mood m = new Mood();
		
		m.setName(mood.getName());
		EntityService.em.persist(m);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return m;
	}	
	
	/**
	 * Deletes a Mood with the given ID.
	 * @param id
	 */
	public void deleteMood(int id) {
		Mood m = EntityService.em.find(Mood.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(m);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
	}
	
	
	/**
	 * Gets a Symptom with the given ID.
	 * @param id
	 * @return the found Symptom instance or null if the entity does not exist.
	 */
	public Symptom getSymptom(int id) {
		return EntityService.em.find(Symptom.class, id);
		
	}
	
	/**
	 * Updates the Symptom with the given ID.
	 * @param id
	 * @param symptom
	 * @return the Symptom.
	 */
	public Symptom updateSymptom(int id, Symptom symptom) {
		EntityService.em.getTransaction().begin();
		
		Symptom s = EntityService.em.find(Symptom.class, id);
		
		s.setName(symptom.getName());
		
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return s;
	}
	
	
	/**
	 * Adds a Symptom.
	 * @param symptom
	 * @return the new Symptom.
	 */
	public Symptom addSymptom(Symptom symptom) {
		EntityService.em.getTransaction().begin();
		
		Symptom s = new Symptom();
		
		s.setName(symptom.getName());
		EntityService.em.persist(s);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return s;
	}	
	
	/**
	 * Deletes a Symptom with the given ID
	 * @param id
	 */
	public void deleteSymptom(int id) {
		Symptom s = EntityService.em.find(Symptom.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(s);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
	}
	
	

	/**
	 * Gets an Activity with the given ID.
	 * @param id
	 * @return the found Activity instance or null if the entity does not exist.
	 */
	public Activity getActivity(int id) {
		return EntityService.em.find(Activity.class, id);
		
	}
	
	/**
	 * Updates an activity with the given ID.
	 * @param id
	 * @param Activity
	 * @return the Activity.
	 */
	public Activity updateActivity(int id, Activity activity) {
		EntityService.em.getTransaction().begin();
		
		Activity a = EntityService.em.find(Activity.class, id);
		
		a.setName(activity.getName());
		
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return a;
	}
	
	
	/**
	 * Adds an activity.
	 * @param Activity
	 * @return the new Activity.
	 */
	public Activity addActivity(Activity activity) {
		EntityService.em.getTransaction().begin();
		
		Activity a = new Activity();
		
		a.setName(activity.getName());
		EntityService.em.persist(a);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return a;
	}	
	
	/**
	 * Deletes an activity with the given ID
	 * @param id
	 */
	public void deleteActivity(int id) {
		Activity a = EntityService.em.find(Activity.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(a);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
	}
	
	
}
