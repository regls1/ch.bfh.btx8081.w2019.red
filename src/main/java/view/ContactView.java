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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import ch.bfh.btx8081.w2019.red.SocialDisorderApp.MainView;
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
			boxContact2Person.add(new Button(contact.getTitle()+" "+ contact.getFirstName()+" " + contact.getName()));
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

	private Dialog createDialog() {
		Dialog dialog = new Dialog();
		//Contact contact = new Contact();
		
		VerticalLayout vLayout = new VerticalLayout();
		
		HorizontalLayout dialogLayoutContact = new HorizontalLayout();		
		Label lblContact = new Label("Name: ");
		lblContact.setWidth("130px");
		Label lblContactData = new Label("Titel + Vorname + Nachname");
		//Label lblContactData = new Label(contact.getTitle() + contact.getFirstName() + contact.getName());
		dialogLayoutContact.add(lblContact, lblContactData);
		
		HorizontalLayout dialogLayoutAddress = new HorizontalLayout();
		Label lblAddress = new Label("Adresse: ");
		lblAddress.setWidth("130px");
		Label lblAddressContact = new Label("Strasse + Stadt");
		dialogLayoutAddress.add(lblAddress, lblAddressContact);
		
		HorizontalLayout dialogLayoutPhone = new HorizontalLayout();
		Label lblPhone = new Label("Telefonnummer: ");
		lblPhone.setWidth("130px");
		Label lblPhoneContact = new Label("Telefonnummer");
		dialogLayoutPhone.add(lblPhone, lblPhoneContact);
		
		HorizontalLayout dialogLayoutMail = new HorizontalLayout();
		Label lblMail = new Label("E-Mail: ");
		lblMail.setWidth("130px");
		Label lblMailContact = new Label("Email");
		dialogLayoutMail.add(lblMail, lblMailContact);	
			
		vLayout.add(dialogLayoutContact, dialogLayoutAddress, dialogLayoutPhone, dialogLayoutMail);
		dialog.add(vLayout);
		
		HorizontalLayout dialogLayoutMenu = new HorizontalLayout();
		
		Button btnDelete = new Button("Kontakt löschen", new Icon(VaadinIcon.TRASH), event -> {
			//DOING SOMETHING
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
		//Label lblTitleDialog = new Label("Neuer Kontakt erstellen");
		
		VerticalLayout vLayout = new VerticalLayout();
		HorizontalLayout dialogLayoutTitle = new HorizontalLayout();		
		Label lblTitle = new Label("Titel: ");
		lblTitle.setWidth("130px");
		TextField txtTitle = new TextField();
		dialogLayoutTitle.add(lblTitle, txtTitle);
		
		HorizontalLayout dialogLayoutFirstname = new HorizontalLayout();
		Label lblFirstname = new Label("Vorname: ");
		lblFirstname.setWidth("130px");
		TextField txtFirstname = new TextField();
		dialogLayoutFirstname.add(lblFirstname, txtFirstname);
		
		HorizontalLayout dialogLayoutName = new HorizontalLayout();
		Label lblName = new Label("Name: ");
		lblName.setWidth("130px");
		TextField txtName = new TextField();
		dialogLayoutName.add(lblName, txtName);
		
		HorizontalLayout dialogLayoutPhone = new HorizontalLayout();
		Label lblPhone = new Label("Telefonnummer: ");
		lblPhone.setWidth("130px");
		TextField txtPhone = new TextField();
		dialogLayoutPhone.add(lblPhone, txtPhone);
		
		HorizontalLayout dialogLayoutMail = new HorizontalLayout();
		Label lblMail = new Label("Email: ");
		lblMail.setWidth("130px");
		TextField txtMail = new TextField();
		dialogLayoutMail.add(lblMail, txtMail);
		
		HorizontalLayout dialogLayoutStreet = new HorizontalLayout();
		Label lblStreet = new Label("Strasse: ");
		lblStreet.setWidth("130px");
		TextField txtStreet = new TextField();
		dialogLayoutStreet.add(lblStreet, txtStreet);
		
		HorizontalLayout dialogLayoutCity = new HorizontalLayout();
		Label lblCity = new Label("Stadt: ");
		lblCity.setWidth("130px");
		TextField txtCity = new TextField();
		dialogLayoutCity.add(lblCity, txtCity);
		
		vLayout.add(dialogLayoutTitle, dialogLayoutFirstname, dialogLayoutName, dialogLayoutPhone, dialogLayoutMail, dialogLayoutStreet, dialogLayoutCity);
		dialog.add(vLayout);
		
		HorizontalLayout dialogLayoutMenu = new HorizontalLayout();
		//Button btnSave = new Button("Speichern", new Icon(VaadinIcon.DISC));
		
		Button btnSave = new Button("Speichern", new Icon(VaadinIcon.DISC), event -> {
			Contact contact = new Contact();
			contact.setTitle(txtTitle.getValue());
			contact.setFirstName(txtFirstname.getValue());
			contact.setName(txtName.getValue());
			contact.setMobile(txtPhone.getValue());
			contact.setMail(txtMail.getValue());
			contact.setStreet(txtStreet.getValue());
			csc.addContact(contact);
			
			/**
			System.out.println(txtTitle.getValue());
			System.out.println(txtFirstname.getValue());
			System.out.println(txtName.getValue());
			System.out.println(txtPhone.getValue());
			System.out.println(txtMail.getValue());
			System.out.println(txtStreet.getValue());
			System.out.println(txtCity.getValue());
			*/
			dialog.close();
		});
		
		Button btnClose = new Button("Abbrechen", new Icon(VaadinIcon.CLOSE), event -> {
			dialog.close();
		});
		dialogLayoutMenu.add(btnSave, btnClose);
		dialog.add(dialogLayoutMenu);
		
		return dialog;
	}

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
}