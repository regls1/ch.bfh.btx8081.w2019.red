package view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DiaryView extends VerticalLayout {

	
    
	
	public DiaryView(){
	add(new H1("Hello!!!"));

	
	Button button = new Button("Hello", event -> Notification.show("Clicked!"));
	}
	
	
	
}
