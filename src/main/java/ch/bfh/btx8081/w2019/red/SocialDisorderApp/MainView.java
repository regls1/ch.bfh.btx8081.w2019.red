package ch.bfh.btx8081.w2019.red.SocialDisorderApp;
import view.ExerciseView;

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
     	Button contact = new Button("Contact", event -> Notification.show("Clicked!"));
        add(contact);
        Button exercise = new Button("Exercise", event -> Notification.show("Clicked!"));
        add(exercise);
        Button diary = new Button("Diary", event -> Notification.show("Clicked!"));
        add(diary);
        l.add(contact, exercise, diary);
        add(l);
        
        Button button = new Button(new Image("img/contact.png", "Contact logo"));
        add(button);
        
        Button test = new Button(add(new RouterLink("Exercise", ExerciseView.class)));
        add(test);
        
  
    }
}
