package model;

public class MainTestClass {

	public static void main(String[] args) {
		
		
		
		ContactServiceClass csc = new ContactServiceClass();
		
		//Contact contact1 = new Contact();
		City city1 = new City();
		//city1.setId(12);
		city1.setName("Bern");
		city1.setZip(2555);
		csc.addCity(city1);
		
		/*
		contact1.setCityId(city1.getId());
		contact1.setFirstName("asd");
		contact1.setMail("asdj");
		contact1.setMobile("123");
		contact1.setStatusId(Status.absent);
		contact1.setStreet(street);
		csc.addContact(contact1);
		*/
		//System.out.println(csc.addContact(contact1));
	}

}
