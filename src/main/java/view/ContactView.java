package view;

import java.util.List;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import ch.bfh.btx8081.w2019.red.SocialDisorderApp.MainView;
import model.City;
import model.Contact;
import service.ContactService;

/**
 * A list of all Contacts for a patient with emergency Contacts.
 * 
 * @author gashf2, regls1
 *
 */
@SuppressWarnings("serial")
@Route
public class ContactView extends VerticalLayout {

	//Button btnDelete = new Button(new Icon(VaadinIcon.TRASH));
	//Button btnEdit = new Button(new Icon(VaadinIcon.EYE));
	Label lblTitle;
	
	// create new contact service
	ContactService csc = new ContactService();
	// contact service reads all contacts from database and saves them into a list
	List<Contact> allContacts = csc.getAllContacts();
	
	public ContactView() {
		Button btnReturn = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		Button btnNewContact2 = new Button("Neuer Kontakt erstellen");
		btnNewContact2.addClickListener(event -> createContact2Dialog().open());
		H3 lblContact2Person = new H3("Meine Kontaktpersonen");
		btnReturn.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
		add(btnReturn, btnNewContact2, lblContact2Person);
		ListBox<Button> boxContact2Person = new ListBox<Button>();
		boxContact2Person.setSizeFull();

		// loop through contact list and create buttons for gui
		for(Contact contact : allContacts) {
			Button b = new Button(contact.getTitle()+" "+ contact.getFirstName()+" " + contact.getName());
			boxContact2Person.add(b);
			b.addClickListener(event -> createDialog(contact.getId()).open());
			System.out.println(contact.getId());
		}
		
		// add to gui
		add(boxContact2Person);
		

		H3 lblMoreContact2s = new H3("Weiterführende Kontakte");
		add(lblMoreContact2s);
		ListBox<Button> boxMoreContact2 = new ListBox<Button>();
		boxMoreContact2.setSizeFull();
		add(boxMoreContact2);

		/*
		personOne.addClickListener(event -> createDialog().open());
		personTwo.addClickListener(event -> createDialog().open());
		personThree.addClickListener(event -> createDialog().open());
		personFour.addClickListener(event -> createDialog().open());
		personFive.addClickListener(event -> createDialog().open());
		personSix.addClickListener(event -> createDialog().open());
		personSeven.addClickListener(event -> createDialog().open());
		*/
	}

	private Dialog createDialog(int id) {
		Dialog dialog = new Dialog();
		//Contact contact = new Contact();
		
		VerticalLayout vLayout = new VerticalLayout();
		
		Contact contact = csc.getContact(id);
		City city = csc.getCity(contact.getCityId());
		
		HorizontalLayout dialogLayoutContact = new HorizontalLayout();		
		Label lblContact = new Label("Name: ");
		lblContact.setWidth("130px");
		//Label lblContactData = new Label("Titel + Vorname + Nachname");
		Label lblContactData = new Label(contact.getTitle() + " " + contact.getFirstName() + " " + contact.getName());
		dialogLayoutContact.add(lblContact, lblContactData);
		
		HorizontalLayout dialogLayoutAddress = new HorizontalLayout();
		Label lblAddress = new Label("Adresse: ");
		lblAddress.setWidth("130px");
		Label lblAddressContact = new Label(contact.getStreet() + ", " );
		dialogLayoutAddress.add(lblAddress, lblAddressContact);
		
		HorizontalLayout dialogLayoutPhone = new HorizontalLayout();
		Label lblPhone = new Label("Telefonnummer: ");
		lblPhone.setWidth("130px");
		Label lblPhoneContact = new Label(contact.getMobile());
		dialogLayoutPhone.add(lblPhone, lblPhoneContact);
		
		HorizontalLayout dialogLayoutMail = new HorizontalLayout();
		Label lblMail = new Label("E-Mail: ");
		lblMail.setWidth("130px");
		Label lblMailContact = new Label(contact.getMail());
		dialogLayoutMail.add(lblMail, lblMailContact);	
		H3 h3Details = new H3("Details");
		vLayout.add(h3Details, dialogLayoutContact, dialogLayoutAddress, dialogLayoutPhone, dialogLayoutMail);
		dialog.add(vLayout);
		
		HorizontalLayout dialogLayoutMenu = new HorizontalLayout();
		
		Button btnDelete = new Button("Kontakt löschen", new Icon(VaadinIcon.TRASH), event -> {
			csc.deleteContact(id);
			dialog.close();
		});
		
		Button btnClose = new Button("Abbrechen", new Icon(VaadinIcon.CLOSE), event -> {
			dialog.close();
		});
		dialogLayoutMenu.add(btnDelete, btnClose);
		dialog.add(dialogLayoutMenu);
			
		return dialog;
		
		/**
		List<Contact2> Contact2List = new ArrayList<Contact2>();
		Grid<Contact2> grid = new Grid<>();
		Contact2List.add(new Contact2("Status", "Erreichbar"));
		Contact2List.add(new Contact2("Uhrzeiten", "Mo-Fr: 08:00-17:00"));
		Contact2List.add(new Contact2("Standort", "Bahnhofstr. 12, 8004 Zürich"));
		Contact2List.add(new Contact2("Telefonnummer", "076 123 45 67"));
		Contact2List.add(new Contact2("E-Mail", "test@bfh.ch"));

		grid.setItems(Contact2List);
		grid.addColumn(Contact2::getTextInfo);
		grid.addColumn(Contact2::getText);
		grid.setWidth("500px");
		grid.setHeightByRows(true);
		VerticalLayout dialogLayout = new VerticalLayout();
		Button btnClose = new Button(new Icon(VaadinIcon.CLOSE), event -> {
			dialog.close();
		});
		new H3("Dr. med. Hans Peter");
		dialogLayout.add(btnClose, new Label(personOne.getText()), grid);
		dialog.add(dialogLayout);
		return dialog;
		*/
	}
	
	private Dialog createContact2Dialog() {
		Dialog dialog = new Dialog();
		H3 lblTitleDialog = new H3("Neuer Kontakt erstellen");
		VerticalLayout vLayout = new VerticalLayout();
		HorizontalLayout dialogLayoutName = new HorizontalLayout();
		TextField txtTitle = new TextField("Titel");
		TextField txtFirstname = new TextField("Vorname");
		TextField txtName = new TextField("Name");
		dialogLayoutName.add(txtTitle, txtFirstname, txtName);
		HorizontalLayout dialogLayoutPhone = new HorizontalLayout();
		TextField txtPhone = new TextField("Telefonnummer");
		dialogLayoutPhone.add(txtPhone);
		HorizontalLayout dialogLayoutMail = new HorizontalLayout();
		TextField txtMail = new TextField("E-Mail");
		dialogLayoutMail.add(txtMail);
		HorizontalLayout dialogLayoutAddress = new HorizontalLayout();
		TextField txtStreet = new TextField("Strasse");
		TextField txtPLZ = new TextField("PLZ");
		TextField txtCity = new TextField("Stadt");
		dialogLayoutAddress.add(txtStreet, txtPLZ, txtCity);
		vLayout.add(lblTitleDialog, dialogLayoutName, dialogLayoutPhone, dialogLayoutMail, dialogLayoutAddress);
		dialog.add(vLayout);
		HorizontalLayout dialogLayoutMenu = new HorizontalLayout();
		//Button btnSave = new Button("Speichern", new Icon(VaadinIcon.DISC));
		
		Button btnSave = new Button("Speichern", new Icon(VaadinIcon.DISC), event -> {
			Dialog dialog2 = new Dialog();
			Button btnOk = new Button("OK");
			HorizontalLayout dialogWarning = new HorizontalLayout();
			Label lblWarning = new Label("Diese Postleitzahl ist nicht erlaubt.");
			dialogWarning.add(lblWarning, btnOk);
			dialog2.add(dialogWarning);
			
			List<City> cityList = csc.getAllCities();
			for(City selectedCity : cityList) {
				if(selectedCity.getZip() == Integer.parseInt(txtPLZ.getValue())) {
					Contact contact = new Contact();
					City city = new City();
					contact.setTitle(txtTitle.getValue());
					contact.setFirstName(txtFirstname.getValue());
					contact.setName(txtName.getValue());
					contact.setMobile(txtPhone.getValue());
					contact.setMail(txtMail.getValue());
					contact.setStreet(txtStreet.getValue());
					city.setZip(Integer.parseInt(txtPLZ.getValue()));
					city.setName(txtCity.getValue());
					contact.setCityId(city.getId());
					csc.addCity(city);
					csc.addContact(contact);
					dialog.close();
				} else {
					//Notification not = new Notification("This PLZ is not allowed");
					
					
					//btnOk.addClickListener(event2 -> dialog2.close());
					
					dialog2.open();
					
					
				}
				btnOk.addClickListener(event2 -> dialog2.close());
			}
			
			
			
			/**
			System.out.println(txtTitle.getValue());
			System.out.println(txtFirstname.getValue());
			System.out.println(txtName.getValue());
			System.out.println(txtPhone.getValue());
			System.out.println(txtMail.getValue());
			System.out.println(txtStreet.getValue());
			System.out.println(txtCity.getValue());
			*/
			
		});
		
		Button btnClose = new Button("Abbrechen", new Icon(VaadinIcon.CLOSE), event -> {
			dialog.close();
		});
		dialogLayoutMenu.add(btnSave, btnClose);
		dialog.add(dialogLayoutMenu);
		
		return dialog;
	}

	/*
	public class Contact2 {

		private String textInfo;
		private String text;

		public Contact2(String textInfo, String text) {
			this.textInfo = textInfo;
			this.text = text;
		}

		public String getTextInfo() {
			return textInfo;
		}

		public String getText() {
			return text;
		}

		public void setTextInfo(String textInfo) {
			this.textInfo = textInfo;
		}

		public void setText(String text) {
			this.text = text;
		}
	}
	*/
}