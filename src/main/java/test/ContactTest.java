package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Contact;
import presenter.ContactPresenter;
import service.ContactService;

/** 
 * This JUnit-Test tests the Contact classes
 * @author regls1, gashf2
 *
 */

public class ContactTest {

	private ContactPresenter cPresenter = new ContactPresenter();
	private ContactService cService = new ContactService();
	
	public int testGetContactId(String email) {
		int contactId = 0;
		for (Contact contact : cService.getAllContacts()) {
			if (contact.getMail().equals(email)) {
				contactId = contact.getId();
			}
		}
		return contactId;
	}
	
	@Test
	public void testAddContact() {
		cPresenter.saveContact("Dr. med.", "Hansjürg", "Rubino", "0335554433", "hansjuerg.rubino@bfh.ch", "Bahnhofstrasse 33", 2, "3172");
		assertTrue(cPresenter.checkCity("3172"));
		//cPresenter.saveContact("Prof. Dr.", "Martin", "Müller", "0332211333", "martin.mueller@bfh.ch", "Dorfweg 102", 1, "8002");
		//assertFalse(cPresenter.checkCity("8002"));
	}
	
	@Test
	public void testGetContact() {
		int id = this.testGetContactId("hansjuerg.rubino@bfh.ch");
		Contact contact = cPresenter.getContact(id);
		assertEquals(contact.getName(), "Rubino");
	}
	
	@Test
	public void testContact() {
		int id = this.testGetContactId("hansjuerg.rubino@bfh.ch");
		Contact contact = cPresenter.getContact(id);
		assertTrue(contact.getTitle().equals("Dr. med."));
		assertFalse(contact.getTitle().equals("Prof. med."));
		assertTrue(contact.getFirstName().equals("Hansjürg"));
		assertFalse(contact.getFirstName().equals("Hansjürg"));
		assertTrue(contact.getName().equals("Rubino"));
		assertFalse(contact.getName().equals("Rubino"));
		assertTrue(contact.getMobile().equals("0335554433"));
		assertFalse(contact.getMobile().equals("0335554433"));
		assertTrue(contact.getStreet().equals("Bahnhofstrasse 33"));
		assertFalse(contact.getStreet().equals("Bahnhofstrasse 33"));
		assertTrue(contact.getUserId() == (2));
		assertFalse(contact.getUserId() == (1));
	}
	
	@Test
	public void testDeleteContact() {
		int id = this.testGetContactId("hansjuerg.rubino@bfh.ch");
		Contact contact = cPresenter.getContact(id);
		cPresenter.deleteContact(id);
		assertFalse(contact.getName().equals("Rubino"));
	}
}