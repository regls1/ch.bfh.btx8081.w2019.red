package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
	
	public ContactView() {
		Button contactPersonButton = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		HorizontalLayout contactPersonLayout = new HorizontalLayout();
		H3 contactPersonLabel = new H3("Meine Kontaktpersonen");
		contactPersonButton.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
		contactPersonLayout.add(contactPersonLabel);
		add(contactPersonButton, contactPersonLayout);
		
		ListBox<Button> contactPersonBox = new ListBox<Button>();
		Button b1 = new Button("Person 1");
		Button b2 = new Button("Person 2");
		Button b3 = new Button("Person 3");
		Button b4 = new Button("Person 4");
		contactPersonBox.setWidth("100%");
		contactPersonBox.add(b1, b2, b3, b4);
		add(contactPersonBox);
		
		H3 moreContactsLabel = new H3("Weiterführende Kontakte");
		add(moreContactsLabel);
		
		ListBox<Button> moreContactsBox = new ListBox<Button>();
		Button a1 = new Button("Person 1");
		Button a2 = new Button("Person 2");
		Button a3 = new Button("Person 3");
		Button a4 = new Button("Person 4");
		moreContactsBox.setWidth("100%");
		moreContactsBox.add(a1, a2, a3, a4);
		add(moreContactsBox);
		
		Dialog b1dialog = new Dialog();
		b1.addClickListener(event -> b1dialog.open());
		List<Contact> contactList = new ArrayList<Contact>();
		Grid<Contact> grid = new Grid<>();
		contactList.add(new Contact("Status", "Erreichbar"));
		contactList.add(new Contact("Uhrzeiten","Mo-Fr: 08:00-17:00"));
		contactList.add(new Contact("Standort","Bahnhofstr. 12, 8004 Zürich"));
		contactList.add(new Contact("Telefonnummer","076 123 45 67"));
		grid.setItems(contactList);
		grid.addColumn(Contact::getTextInfo);
		grid.addColumn(Contact::getText);
		grid.setWidth("500px");
		VerticalLayout dialogLayout = new VerticalLayout();
		Button closeButton = new Button(new Icon(VaadinIcon.CLOSE), event -> {
			b1dialog.close();
		});
		H3 nameContact = new H3("Dr. med. Hans Peter");
		dialogLayout.add(closeButton, nameContact, grid);
		b1dialog.add(dialogLayout);
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