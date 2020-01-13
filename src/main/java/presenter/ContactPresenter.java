package presenter;

import java.util.List;

import model.City;
import model.Contact;
import model.Status;
import service.ContactService;

/**
 * Presenter for Contacts
 * 
 * @author gashf2
 * 
 */

public class ContactPresenter {
	private Contact contact;
	private ContactService csc = new ContactService();

	public void saveContact(String title, String firstName, String name, String mobile, String mail, String street, int kind) {
		contact = new Contact();

		contact.setTitle(title);
		contact.setFirstName(firstName);
		contact.setName(name);
		contact.setMobile(mobile);
		contact.setMail(mail);
		contact.setStreet(street);
		contact.setUserId(kind);

		csc.addContact(contact);
	}

	public List<Contact> getAllContacts() {
		return csc.getAllContacts();
	}
	
	public List<City> getAllCities() {
		return csc.getAllCities();
	}

	public Contact getContact(int id) {
		return csc.getContact(id);
	}

	public void deleteContact(int id) {
		csc.deleteContact(id);
	}
	
	public void setStatus(int status) {
		
	}
}