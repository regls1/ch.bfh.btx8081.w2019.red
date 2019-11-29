package view;

import java.util.ArrayList;
import java.util.List;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ch.bfh.btx8081.w2019.red.SocialDisorderApp.MainView;

/**
 * A list of all contacts for a patient with emergency contacts.
 * 
 * @author Floriana
 *
 */
@SuppressWarnings("serial")
@Route
public class ContactView extends VerticalLayout {

	Button personOne = new Button("Dr. med. Hans Müller");
	Button personTwo = new Button("Dr. med Anna Schmid");
	Button personThree = new Button("George Meyer");
	Button personFour = new Button("Marie Goodwill");
	Button personFive = new Button("Notfall");
	Button personSix = new Button("Notfallpsychiatrie");
	Button personSeven = new Button("Dr. med. Tim Meier");

	public ContactView() {
		Button btnReturn = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		H3 lblContactPerson = new H3("Meine Kontaktpersonen");
		btnReturn.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
		add(btnReturn, lblContactPerson);
		ListBox<Button> boxContactPerson = new ListBox<Button>();
		boxContactPerson.setSizeFull();
		boxContactPerson.add(personOne, personTwo, personThree, personFour);
		add(boxContactPerson);

		H3 lblMoreContacts = new H3("Weiterführende Kontakte");
		add(lblMoreContacts);
		ListBox<Button> boxMoreContact = new ListBox<Button>();
		boxMoreContact.setSizeFull();
		boxMoreContact.add(personFive, personSix, personSeven);
		add(boxMoreContact);

		personOne.addClickListener(event -> createDialog().open());
		personTwo.addClickListener(event -> createDialog().open());
		personThree.addClickListener(event -> createDialog().open());
		personFour.addClickListener(event -> createDialog().open());
		personFive.addClickListener(event -> createDialog().open());
		personSix.addClickListener(event -> createDialog().open());
		personSeven.addClickListener(event -> createDialog().open());
	}

	private Dialog createDialog() {
		Dialog dialog = new Dialog();

		List<Contact> contactList = new ArrayList<Contact>();
		Grid<Contact> grid = new Grid<>();
		contactList.add(new Contact("Status", "Erreichbar"));
		contactList.add(new Contact("Uhrzeiten", "Mo-Fr: 08:00-17:00"));
		contactList.add(new Contact("Standort", "Bahnhofstr. 12, 8004 Zürich"));
		contactList.add(new Contact("Telefonnummer", "076 123 45 67"));
		grid.setItems(contactList);
		grid.addColumn(Contact::getTextInfo);
		grid.addColumn(Contact::getText);
		grid.setWidth("500px");
		grid.setHeightByRows(true);
		VerticalLayout dialogLayout = new VerticalLayout();
		Button btnClose = new Button(new Icon(VaadinIcon.CLOSE), event -> {
			dialog.close();
		});
		H3 lblNameContact = new H3("Dr. med. Hans Peter");
		dialogLayout.add(btnClose, new Label(personOne.getText()), grid);
		dialog.add(dialogLayout);
		return dialog;
	}

	public class Contact {

		private String textInfo;
		private String text;

		public Contact(String textInfo, String text) {
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