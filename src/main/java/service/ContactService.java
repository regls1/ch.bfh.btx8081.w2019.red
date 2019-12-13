package service;

import java.util.ArrayList;

import model.City;
import model.Contact;
import model.User;

public class ContactService {

	
	
	
	/**
	 * get an user based on the id 
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		return EntityService.em.find(User.class, id);
	}
	
	/**
	 * get a list of all cities
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<City> getAllExercises() {
		return (ArrayList<City>)EntityService.em.createQuery("select c from City c").getResultList();
	}
 
	/**
	 * get a city based on the id
	 * @param id
	 * @return
	 */
	public City getCity(int id) {
		return EntityService.em.find(City.class, id);
	}
	
	/**
	 * update existing city
	 * @param id
	 * @param city
	 * @return
	 */
	public City updateCity(int id, City city) {
		EntityService.em.getTransaction().begin();
		
		City c = EntityService.em.find(City.class, id);
		
		c.setZip(city.getZip());
		c.setName(city.getName());
		
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return c;
	}
 
	/**
	 * add a city 
	 * @param city
	 * @return
	 */
	public City addCity(City city) {
		EntityService.em.getTransaction().begin();
		
		City c = new City();
		
		c.setZip(city.getZip());
		c.setName(city.getName());
		
		EntityService.em.persist(c);
		
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		//EntityService.em.close();
		
		return c;
	}	
 
	/**
	 * delete a city
	 * @param city
	 */
	public void deleteCity(int id) {
		City c = EntityService.em.find(City.class, id);
		try {
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(c);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		}catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * get a list of all contacts
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Contact> getAllContacts() {
		return (ArrayList<Contact>)EntityService.em.createQuery("select c from Contact c").getResultList();
	}
 
	/**
	 * get a contact based on the id
	 * @param id
	 * @return
	 */
	public Contact getContact(int id) {
		return EntityService.em.find(Contact.class, id);
	}
	
	/**
	 * update existing contact
	 * @param id
	 * @param contact
	 * @return
	 */
	public Contact updateContact(int id, Contact contact) {
		EntityService.em.getTransaction().begin();
		
		Contact c = EntityService.em.find(Contact.class, id);
		
		c.setTitle(contact.getTitle());
		c.setFirstName(contact.getFirstName());
		c.setName(contact.getName());
		c.setMail(contact.getMail());
		c.setMobile(contact.getMobile());
		c.setStatusId(contact.getStatusId());
		c.setStreet(contact.getStreet());
		//foreign keys cityid and userid stay the same
		
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return c;
	}
 
	/**
	 * add a contact 
	 * @param contact
	 * @return
	 */
	public Contact addContact(Contact contact) {
		EntityService.em.getTransaction().begin();
		
		Contact c = new Contact();
		
		c.setTitle(contact.getTitle());
		c.setFirstName(contact.getFirstName());
		c.setName(contact.getName());
		c.setMail(contact.getMail());
		c.setMobile(contact.getMobile());
		c.setStatusId(contact.getStatusId());
		c.setUserId(contact.getUserId());
		c.setStreet(contact.getStreet());
		
		EntityService.em.persist(c);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
		
		return c;
	}	
 
	/**
	 * delete a contact
	 * @param city
	 */
	public void deleteContact(int id) {
		Contact c = EntityService.em.find(Contact.class, id);
		
		EntityService.em.getTransaction().begin();
		EntityService.em.remove(c);
		EntityService.em.flush();
		EntityService.em.getTransaction().commit();
		
	}
}
