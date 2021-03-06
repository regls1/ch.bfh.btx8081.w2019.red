package view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
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
import model.Contact;
import presenter.ContactPresenter;

/**
 * A list of all Contacts for a patient with emergency Contacts.
 * 
 * @author gashf2, regls1
 *
 */
@SuppressWarnings("serial")
@Route
public class ContactView extends VerticalLayout {

	Label lblTitle;
	ListBox<Button> boxMoreContacts;
	ListBox<Button> boxContacts;
	ContactPresenter presenter = new ContactPresenter();

	public ContactView() {
		Button btnReturn = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		Button btnNewContact = new Button("Neuer Kontakt", new Icon(VaadinIcon.PLUS));
		btnNewContact.addClickListener(event -> openContactAddDialog("Normal").open());
		H2 lblContactPerson = new H2("Meine Kontaktpersonen");
		btnReturn.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
		add(btnReturn, lblContactPerson, btnNewContact);
		boxContacts = new ListBox<Button>();
		boxContacts.setSizeFull();

		boxMoreContacts = new ListBox<Button>();
		boxMoreContacts.setSizeFull();

		// loop through contact list and create buttons for gui
		for (Contact contact : presenter.getAllContacts()) {
			Button b = new Button(contact.getTitle() + " " + contact.getFirstName() + " " + contact.getName());
			if (contact.getUserId() == 1) {
				boxMoreContacts.add(b);
			} else if (contact.getUserId() == 2) {
				boxContacts.add(b);
			}

			b.addClickListener(event -> openContactDetailDialog(contact.getId()).open());
			System.out.println(contact.getId());
		}

		add(boxContacts);

		H2 lblMoreContacts = new H2("Weiterführende Kontakte");
		Button btnNewFurtherContact = new Button("Neuer Kontakt", new Icon(VaadinIcon.PLUS));
		btnNewFurtherContact.addClickListener(event -> openContactAddDialog("Further").open());
		add(lblMoreContacts, btnNewFurtherContact);

		add(boxMoreContacts);
	}

	/**
	 * method to get a dialog with the information of the contact
	 * 
	 * @param id, id of the contact
	 * @return dialog, dialog with the information of a contact
	 */
	public Dialog openContactDetailDialog(int id) {
		Dialog dialog = new Dialog();

		VerticalLayout vLayout = new VerticalLayout();

		HorizontalLayout dialogLayoutContact = new HorizontalLayout();
		Label lblContact = new Label("Name: ");
		lblContact.setWidth("130px");
		Label lblContactData = new Label(presenter.getContact(id).getTitle() + " "
				+ presenter.getContact(id).getFirstName() + " " + presenter.getContact(id).getName());
		dialogLayoutContact.add(lblContact, lblContactData);

		HorizontalLayout dialogLayoutAddress = new HorizontalLayout();
		Label lblAddress = new Label("Adresse: ");
		lblAddress.setWidth("130px");
		Label lblAddressContact = new Label(presenter.getContact(id).getStreet() + ", "
				+ presenter.getCity(presenter.getContact(id).getCityId()).getZip() + " "
				+ presenter.getCity(presenter.getContact(id).getCityId()).getName());
		dialogLayoutAddress.add(lblAddress, lblAddressContact);

		HorizontalLayout dialogLayoutPhone = new HorizontalLayout();
		Label lblPhone = new Label("Telefonnummer: ");
		lblPhone.setWidth("130px");
		Label lblPhoneContact = new Label(presenter.getContact(id).getMobile());
		dialogLayoutPhone.add(lblPhone, lblPhoneContact);

		HorizontalLayout dialogLayoutMail = new HorizontalLayout();
		Label lblMail = new Label("E-Mail: ");
		lblMail.setWidth("130px");
		Label lblMailContact = new Label(presenter.getContact(id).getMail());
		dialogLayoutMail.add(lblMail, lblMailContact);
		H2 h3Details = new H2("Details");
		vLayout.add(h3Details, dialogLayoutContact, dialogLayoutAddress, dialogLayoutPhone, dialogLayoutMail);
		dialog.add(vLayout);

		HorizontalLayout dialogLayoutMenu = new HorizontalLayout();

		Button btnDelete = new Button("Kontakt löschen", new Icon(VaadinIcon.TRASH), event -> {
			presenter.deleteContact(id);
			dialog.close();
		});

		Button btnClose = new Button("Abbrechen", new Icon(VaadinIcon.CLOSE), event -> {
			dialog.close();
		});
		dialogLayoutMenu.add(btnDelete, btnClose);
		dialog.add(dialogLayoutMenu);

		return dialog;
	}

	/**
	 * method to save a new contact
	 * 
	 * @return dialog, dialog with the fields for the needed information
	 */
	private Dialog openContactAddDialog(String kind) {
		Dialog dialog = new Dialog();
		H2 lblTitleDialog = new H2("Neuer Kontakt erstellen");
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
		if (kind.equals("Normal")) {
			rbgKind.setValue("Nein");
		} else {
			rbgKind.setValue("Ja");
		}
		rbgKind.setEnabled(false);

		vLayout.add(lblTitleDialog, dialogLayoutName, dialogLayoutPhone, dialogLayoutMail, dialogLayoutAddress,
				rbgKind);
		dialog.add(vLayout);

		Button btnSave = new Button("Speichern", new Icon(VaadinIcon.DISC), event -> {
			Dialog dialogCityWarning = new Dialog();
			Button btnOk = new Button("OK");
			HorizontalLayout layoutWarning = new HorizontalLayout();
			Label lblWarning = new Label("Diese Postleitzahl ist nicht erlaubt.");
			layoutWarning.add(lblWarning, btnOk);
			dialogCityWarning.add(layoutWarning);

			btnOk.addClickListener(event2 -> dialogCityWarning.close());
			if (rbgKind.getValue().equals("Ja")) {
				if (presenter.checkCity(txtPLZ.getValue()) == false) {
					dialogCityWarning.open();
				} else {
					presenter.saveContact(txtTitle.getValue(), txtFirstname.getValue(), txtName.getValue(),
							txtPhone.getValue(), txtMail.getValue(), txtStreet.getValue(), 1, txtPLZ.getValue());
					dialog.close();
				}
			} else {
				if (presenter.checkCity(txtPLZ.getValue()) == false) {
					dialogCityWarning.open();
				} else {
					presenter.saveContact(txtTitle.getValue(), txtFirstname.getValue(), txtName.getValue(),
							txtPhone.getValue(), txtMail.getValue(), txtStreet.getValue(), 2, txtPLZ.getValue());
					dialog.close();
				}
			}
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