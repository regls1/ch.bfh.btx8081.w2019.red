package view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
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
@Route
public class ContactView extends VerticalLayout {
	
	public ContactView() {
		HorizontalLayout contactPersonLayout = new HorizontalLayout();
    	Button contactPersonButton = new Button("Zurück", new Icon(VaadinIcon.ARROW_LEFT));
		H3 contactPersonLabel = new H3("Meine Kontaktpersonen");
		contactPersonButton.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
		contactPersonLayout.add(contactPersonButton, contactPersonLabel);
		add(contactPersonLayout);
		
		ListBox<Button> contactPersonBox = new ListBox<Button>();
		Button b1 = new Button("Person 1");
		Button b2 = new Button("Person 2");
		Button b3 = new Button("Person 3");
		Button b4 = new Button("Person 4");
		contactPersonBox.setWidth("100%");
		contactPersonBox.add(b1, b2, b3, b4);
		add(contactPersonBox);
		
		H3 moreContactsLabel = new H3("Weitere Kontakte");
		add(moreContactsLabel);
		
		ListBox<Button> moreContactsBox = new ListBox<Button>();
		Button a1 = new Button("Person 1");
		Button a2 = new Button("Person 2");
		Button a3 = new Button("Person 3");
		Button a4 = new Button("Person 4");
		moreContactsBox.setWidth("100%");
		moreContactsBox.add(a1, a2, a3, a4);
		add(moreContactsBox);
	}
}