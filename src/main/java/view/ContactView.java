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
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
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

	// Button btnDelete = new Button(new Icon(VaadinIcon.TRASH));
	// Button btnEdit = new Button(new Icon(VaadinIcon.EYE));
	Label lblTitle;

	// create new contact service
	ContactService csc = new ContactService();
	// contact service reads all contacts from database and saves them into a list
	List<Contact> allContacts = csc.getAllContacts();
	ListBox<Button> boxMoreContact2;
	ListBox<Button> boxContact2Person;

	public ContactView() {
		Button btnReturn = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		Button btnNewContact2 = new Button("Neuer Kontakt erstellen");
		btnNewContact2.addClickListener(event -> createContact2Dialog().open());
		H3 lblContact2Person = new H3("Meine Kontaktpersonen");
		btnReturn.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
		add(btnReturn, btnNewContact2, lblContact2Person);
		boxContact2Person = new ListBox<Button>();
		boxContact2Person.setSizeFull();

		// loop through contact list and create buttons for gui
		for (Contact contact : allContacts) {
			Button b = new Button(contact.getTitle() + " " + contact.getFirstName() + " " + contact.getName());
			boxContact2Person.add(b);
			b.addClickListener(event -> createDialog(contact.getId()).open());
			System.out.println(contact.getId());
		}

		// add to gui
		add(boxContact2Person);

		H3 lblMoreContact2s = new H3("Weiterführende Kontakte");
		add(lblMoreContact2s);
		boxMoreContact2 = new ListBox<Button>();
		boxMoreContact2.setSizeFull();
		add(boxMoreContact2);
	}

	private Dialog createDialog(int id) {
		Dialog dialog = new Dialog();
		// Contact contact = new Contact();

		VerticalLayout vLayout = new VerticalLayout();

		Contact contact = csc.getContact(id);
		City city = csc.getCity(contact.getCityId());

		HorizontalLayout dialogLayoutContact = new HorizontalLayout();
		Label lblContact = new Label("Name: ");
		lblContact.setWidth("130px");
		// Label lblContactData = new Label("Titel + Vorname + Nachname");
		Label lblContactData = new Label(contact.getTitle() + " " + contact.getFirstName() + " " + contact.getName());
		dialogLayoutContact.add(lblContact, lblContactData);

		HorizontalLayout dialogLayoutAddress = new HorizontalLayout();
		Label lblAddress = new Label("Adresse: ");
		lblAddress.setWidth("130px");
		Label lblAddressContact = new Label(contact.getStreet() + ", ");
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

		RadioButtonGroup<String> rbgKind = new RadioButtonGroup<String>();
		rbgKind.setLabel("Weiterführender Kontakt?");
		rbgKind.setItems("Ja", "Nein");
		rbgKind.setValue("Nein");
		
		
		
		vLayout.add(lblTitleDialog, dialogLayoutName, dialogLayoutPhone, dialogLayoutMail, dialogLayoutAddress, rbgKind);
		dialog.add(vLayout);
		
		// Button btnSave = new Button("Speichern", new Icon(VaadinIcon.DISC));

		Button btnSave = new Button("Speichern", new Icon(VaadinIcon.DISC), event -> {
			Dialog dialog2 = new Dialog();
			Button btnOk = new Button("OK");
			HorizontalLayout dialogWarning = new HorizontalLayout();
			Label lblWarning = new Label("Diese Postleitzahl ist nicht erlaubt.");
			dialogWarning.add(lblWarning, btnOk);
			dialog2.add(dialogWarning);
			Contact contact = new Contact();
			List<City> cityList = csc.getAllCities();
			for (City selectedCity : cityList) {
				if (selectedCity.getZip() == Integer.parseInt(txtPLZ.getValue())) {
					//city = selectedCity;
					contact.setTitle(txtTitle.getValue());
					contact.setFirstName(txtFirstname.getValue());
					contact.setName(txtName.getValue());
					contact.setMobile(txtPhone.getValue());
					contact.setMail(txtMail.getValue());
					contact.setStreet(txtStreet.getValue());
					System.out.println("\n"+selectedCity.getId());
					dialog.close();
				} else {
					dialog2.open();
				}

				btnOk.addClickListener(event2 -> dialog2.close());
			}
			csc.addContact(contact);
			/*
			if(rbgKind.getValue().equals("Ja")) {
				Button b = new Button(contact.getTitle() + " " + contact.getFirstName() + " " + contact.getName());
				boxMoreContact2.add(b);
				b.addClickListener(event2 -> createDialog(contact.getId()).open());
			}
			*/
			

		});

		Button btnClose = new Button("Abbrechen", new Icon(VaadinIcon.CLOSE), event -> {
			dialog.close();
		});
		HorizontalLayout dialogLayoutMenu = new HorizontalLayout();
		dialogLayoutMenu.add(btnSave, btnClose);
		dialog.add(dialogLayoutMenu);

		return dialog;
	}
}