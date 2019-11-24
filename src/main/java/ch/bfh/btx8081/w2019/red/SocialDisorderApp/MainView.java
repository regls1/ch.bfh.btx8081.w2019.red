package ch.bfh.btx8081.w2019.red.SocialDisorderApp;
import view.ExerciseView;
import view.DiaryView;
import view.ContactView;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
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
     	Button contact = new Button("Diary", event -> Notification.show("Clicked!"));
        add(contact);
        add(new RouterLink("Go to the sample contact view!", ContactView.class));
        Button exercise = new Button("Exercise", event -> Notification.show("Clicked!"));
        add(exercise);
        add(new RouterLink("Go to the sample exercise view!", ExerciseView.class));
        Button diary = new Button("Diary", event -> Notification.show("Clicked!"));
        add(diary);
        add(new RouterLink("Go to the sample diary view!", DiaryView.class)); 
        
        
        l.add(contact, exercise, diary);
        add(l);
        
        /**
        Button contact1 = new Button(new Image("img/contact.png", "Contact logo"));
        add(contact1);
        
        Button calender = new Button(new Image("img/calender.png", "Calender logo"));
        add(calender);
        */
          
  
    }
    
    
}
