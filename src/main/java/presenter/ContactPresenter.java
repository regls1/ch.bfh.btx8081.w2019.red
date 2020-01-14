package presenter;

import java.util.List;

import model.City;
import model.Contact;
import service.ContactService;

/**
 * Presenter for Contacts
 * 
 * @author gashf2, regls1
 * 
 */

public class ContactPresenter {
	private Contact contact;
	private ContactService csc = new ContactService();

	/**
	 * method to save a contact
	 * 
	 * @param title, contact title
	 * @param firstName, first name of contact
	 * @param name, family name of contact
	 * @param mobile, mobile phone number of contact
	 * @param mail, mail of contact
	 * @param street, address of contact
	 * @param kind, user id
	 * @param zip, zip code of address of contact
	 */
	public void saveContact(String title, String firstName, String name, String mobile, String mail, String street,
			int kind, String zip) {

		contact = new Contact();
		City city2 = null;
		for(City city : csc.getAllCities()) {
			if(city.getZip() == Integer.parseInt(zip)) {
				city2 = csc.getCity(city.getId());
			}
			
		}

		// set all attributes
		contact.setTitle(title);
		contact.setFirstName(firstName);
		contact.setName(name);
		contact.setMobile(mobile);
		contact.setMail(mail);
		contact.setStreet(street);
		contact.setUserId(kind);
		contact.setCityId(city2.getId());

		csc.addContact(contact);
	}

	/**
	 * method to check city if it already exists
	 * 
	 * @param zip, zip code
	 * @return boolean; true if it exists or false if it doesn't exist
	 */
	public boolean checkCity(String zip) {
		for (City selected : this.getAllCities()) {
			if (selected.getZip() == Integer.parseInt(zip)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * method to return all existing contacts
	 * @return List of all contacts
	 */
	public List<Contact> getAllContacts() {
		return csc.getAllContacts();
	}

	/**
	 * method to return all existing cities
	 * @return List of all cities
	 */
	public List<City> getAllCities() {
		return csc.getAllCities();
	}

	/**
	 * method to return an existing contact by id
	 * @return contact object
	 */
	public Contact getContact(int id) {
		return csc.getContact(id);
	}

	/**
	 * method to delete an existing contact by id
	 * @param id, id of contact
	 */
	public void deleteContact(int id) {
		csc.deleteContact(id);
	}

	/**
	 * method to return an existing city by id
	 * @return city object
	 */
	public City getCity(int cityId) {
		return csc.getCity(cityId);
	}

}