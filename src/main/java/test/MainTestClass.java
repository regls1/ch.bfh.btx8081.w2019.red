package test;

import model.City;
import model.Contact;
import model.Status;
import model.User;
import service.ContactService;
import service.DiaryService;

public class MainTestClass {

	public static void main(String[] args) {
		
		// Test methods in ConactServiceClass 
		
		ContactService csc = new ContactService();
		
		//Test addCity
		City city1 = new City();
		city1.setName("Bern");
		city1.setZip(2555);
		csc.addCity(city1);
		
		//Test deleteCity. only works once
		//csc.deleteCity(1); 
		
		//csc.deleteCity(city1.getId()); //doesn't work
		
		//getCity doesn't work
		//System.out.println(csc.getCity(101));
		
		//Test addContact
		Contact contact1 = new Contact();
		
		User user = new User();
		user.setFirstName("Karl");
		user.setName("Muster");	
		
		contact1.setTitle("DR.phil. soundso");
		contact1.setFirstName("der");
		contact1.setName("Ben");
		contact1.setStatusId(Status.absent);
		contact1.setMobile("123 999 123");	
		contact1.setMail("asjkjhdj@bfh.ch");
		contact1.setCityId(51);
		contact1.setStreet("Catstreet 12");
		contact1.setUserId(user.getId());
		
		//contact1.setStreet("Catstreet");
		csc.addContact(contact1);
	
		//setStreet() doesn't work
		//System.out.println(csc.addContact(contact1));
		
		
		
		user.getId();
		
		DiaryService dsc = new DiaryService();
		
		
		
		
	}

}
