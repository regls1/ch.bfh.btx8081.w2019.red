package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
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
	
	@Before
	public void testAddContact() {
		cPresenter.saveContact("Dr. med.", "Hansjürg", "Rubino", "0335554433", "hansjuerg.rubino@bfh.ch", "Bahnhofstrasse 33", 2, "3172");
		assertTrue(cPresenter.checkCity("3172"));
	}
	
	@Test
	public void testGetContact() {
		int id = this.testGetContactId("hansjuerg.rubino@bfh.ch");
		Contact contact = cPresenter.getContact(id);
		System.out.println(contact.getId());
		assertEquals(contact.getName(), "Rubino");
	}
	
	@Test
	public void testContact() {
		int id = this.testGetContactId("hansjuerg.rubino@bfh.ch");
		Contact contact = cPresenter.getContact(id);
		assertTrue(contact.getTitle().equals("Dr. med."));
		assertFalse(contact.getTitle().equals("Prof. med."));
		assertTrue(contact.getFirstName().equals("Hansjürg"));
		assertFalse(contact.getFirstName().equals("Hans Jürgs"));
		assertTrue(contact.getName().equals("Rubino"));
		assertFalse(contact.getName().equals("Rubin"));
		assertTrue(contact.getMobile().equals("0335554433"));
		assertFalse(contact.getMobile().equals("0315554433"));
		assertTrue(contact.getStreet().equals("Bahnhofstrasse 33"));
		assertFalse(contact.getStreet().equals("Bahnhofstrasse 2"));
		assertTrue(contact.getUserId() == (2));
		assertFalse(contact.getUserId() == (1));
	}
	
	@After
	public void testDeleteContact() {
		int id = this.testGetContactId("hansjuerg.rubino@bfh.ch");
		Contact contact = cPresenter.getContact(id);
		cPresenter.deleteContact(id);
	}
}