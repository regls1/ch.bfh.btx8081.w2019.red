package model;

import java.util.ArrayList;

/**
 * 
 * @author Patricia ,
 *
 */
public class DiaryServiceClass {
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getEntry(int id) {
		return EntityService.em.find(User.class, id);
		
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Entry> getAllEntries() {
		return (ArrayList<Entry>)EntityService.em.createQuery("select e from Entry e").getResultList();
	}
	
	/**
	 * 
	 * @param id
	 * @param entry
	 * @return
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
		
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
		
		return e;
	}
	
	
	/**
	 * 
	 * @param entry
	 * @return
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
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
		
		return e;
	}	
	
	/**
	 * 
	 * @param id
	 */
	public void deleteEntry(int id) {
		Entry e = EntityService.em.find(Entry.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(e);
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getMood(int id) {
		return EntityService.em.find(User.class, id);
		
	}
	
	/**
	 * 
	 * @param id
	 * @param mood
	 * @return
	 */
	public Mood updateMood(int id, Mood mood) {
		EntityService.em.getTransaction().begin();
		
		Mood m = EntityService.em.find(Mood.class, id);
		
		m.setName(mood.getName());
		
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
		
		return m;
	}
	
	
	/**
	 * 
	 * @param mood
	 * @return
	 */
	public Mood addMood(Mood mood) {
		EntityService.em.getTransaction().begin();
		
		Mood m = new Mood();
		
		m.setName(mood.getName());
		EntityService.em.persist(m);
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
		
		return m;
	}	
	
	/**
	 * 
	 * @param id
	 */
	public void deleteMood(int id) {
		Mood m = EntityService.em.find(Mood.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(m);
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getSymptom(int id) {
		return EntityService.em.find(User.class, id);
		
	}
	
	/**
	 * 
	 * @param id
	 * @param symptom
	 * @return
	 */
	public Symptom updateSymptom(int id, Symptom symptom) {
		EntityService.em.getTransaction().begin();
		
		Symptom s = EntityService.em.find(Symptom.class, id);
		
		s.setName(symptom.getName());
		
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
		
		return s;
	}
	
	
	/**
	 * 
	 * @param symptom
	 * @return
	 */
	public Symptom addSymptom(Symptom symptom) {
		EntityService.em.getTransaction().begin();
		
		Symptom s = new Symptom();
		
		s.setName(symptom.getName());
		EntityService.em.persist(s);
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
		
		return s;
	}	
	
	/**
	 * 
	 * @param id
	 */
	public void deleteSymptom(int id) {
		Symptom s = EntityService.em.find(Symptom.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(s);
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
	}
	
	

	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getActivity(int id) {
		return EntityService.em.find(User.class, id);
		
	}
	
	/**
	 * 
	 * @param id
	 * @param Activity
	 * @return
	 */
	public Activity updateActivity(int id, Activity activity) {
		EntityService.em.getTransaction().begin();
		
		Activity a = EntityService.em.find(Activity.class, id);
		
		a.setName(activity.getName());
		
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
		
		return a;
	}
	
	
	/**
	 * 
	 * @param Activity
	 * @return
	 */
	public Activity addActivity(Activity activity) {
		EntityService.em.getTransaction().begin();
		
		Activity a = new Activity();
		
		a.setName(activity.getName());
		EntityService.em.persist(a);
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
		
		return a;
	}	
	
	/**
	 * 
	 * @param id
	 */
	public void deleteActivity(int id) {
		Activity a = EntityService.em.find(Activity.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(a);
		EntityService.em.getTransaction().commit();
		EntityService.em.flush();
	}
	
	
}
