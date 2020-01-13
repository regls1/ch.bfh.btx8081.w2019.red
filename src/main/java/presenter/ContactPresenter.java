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

	public void saveContact(String title, String firstName, String name, String mobile, String mail, String street,
			int kind, String zip) {

		contact = new Contact();
		City city2 = null;
		for(City city : csc.getAllCities()) {
			if(city.getZip() == Integer.parseInt(zip)) {
				city2 = csc.getCity(city.getId());
			}
			
		}

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

	public boolean checkCity(String zip) {
		for (City selected : this.getAllCities()) {
			if (selected.getZip() == Integer.parseInt(zip)) {
				return true;
			}
		}
		return false;
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


	public City getCity(int cityId) {
		return csc.getCity(cityId);
	}

}