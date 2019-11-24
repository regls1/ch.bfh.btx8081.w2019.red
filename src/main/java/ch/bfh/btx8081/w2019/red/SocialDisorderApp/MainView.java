package ch.bfh.btx8081.w2019.red.SocialDisorderApp;
import view.ExerciseView;
import view.DiaryView;
import view.ContactView;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {

    public MainView() {
     	HorizontalLayout l = new HorizontalLayout();
     	//Button contact = new Button("Contact", event -> Notification.show("Clicked!"));
     	
     	Button contact = new Button("Contact", new Icon(VaadinIcon.USER_CARD));
     	contact.setIconAfterText(true);
        contact.setHeight("550px");
        contact.setWidth("350px");
     	add(contact);
        contact.addClickListener(e -> UI.getCurrent().navigate(ContactView.class));
     
        Button exercise = new Button("Exercise", new Icon(VaadinIcon.CHECK_SQUARE_O));
        exercise.setIconAfterText(true);
        exercise.setHeight("550px");
        exercise.setWidth("350px");
        add(exercise);
        exercise.addClickListener(e -> UI.getCurrent().navigate(ExerciseView.class));
       
        Button diary = new Button("Diary", new Icon(VaadinIcon.CALENDAR));
        diary.setIconAfterText(true);
        diary.setHeight("550px");
        diary.setWidth("350px");
        add(diary);
        diary.addClickListener(e -> UI.getCurrent().navigate(DiaryView.class));
     
        l.add(contact, exercise, diary);
        add(l);
        
        //Button contact1 = new Button(new Image("img/contact.png", "Contact logo"));
        //add(contact1);
    }
}