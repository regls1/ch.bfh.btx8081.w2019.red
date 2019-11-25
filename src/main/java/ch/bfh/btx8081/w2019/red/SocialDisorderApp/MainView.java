package ch.bfh.btx8081.w2019.red.SocialDisorderApp;
import view.ExerciseView;
import view.DiaryView;
import view.ContactView;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {

    public MainView() {
    	VerticalLayout l = new VerticalLayout();
     	//Button contact = new Button("Contact", event -> Notification.show("Clicked!"));
     	
     	Button contact = new Button("Contact", new Icon(VaadinIcon.USER_CARD));
     	contact.setIconAfterText(true);
     	contact.setWidth("100%");
        contact.setHeight("150px");
     	add(contact);
        contact.addClickListener(e -> UI.getCurrent().navigate(ContactView.class));
     
        Button exercise = new Button("Exercise", new Icon(VaadinIcon.CHECK_SQUARE_O));
        exercise.setIconAfterText(true);
        exercise.setWidth("100%");
        exercise.setHeight("150px");
        add(exercise);
        exercise.addClickListener(e -> UI.getCurrent().navigate(ExerciseView.class));
          
        Button diary = new Button("Diary", new Icon(VaadinIcon.CALENDAR));
        diary.setIconAfterText(true);
        diary.setWidth("100%");
        diary.setHeight("150px");
        add(diary);
        diary.addClickListener(e -> UI.getCurrent().navigate(DiaryView.class));
     
        l.add(contact, exercise, diary);
        add(l);
        
        //Button contact1 = new Button(new Image("img/contact.png", "Contact logo"));
        //add(contact1);
    }
}