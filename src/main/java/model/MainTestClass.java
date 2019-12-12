package model;

public class MainTestClass {

	public static void main(String[] args) {
		
		// Test methods in ConactServiceClass 
		
		ContactServiceClass csc = new ContactServiceClass();
		
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
		
		contact1.setCityId(51);
		contact1.setFirstName("der");
		contact1.setName("Ben");
		contact1.setMail("asdj@bfh.ch");
		contact1.setMobile("123 123 123");
		contact1.setStatusId(Status.absent);
		contact1.setTitle("DR");
		//contact1.setUserId(13);
		contact1.setStreet("Catstreet");
		csc.addContact(contact1);
	
		//setStreet() doesn't work
		//
		
		
		//System.out.println(csc.addContact(contact1));
	}

}
