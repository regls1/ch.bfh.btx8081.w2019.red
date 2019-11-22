package view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DiaryView extends VerticalLayout {

	
	HorizontalLayout header = new HorizontalLayout();
	
	Button button = new Button("Hello", event -> Notification.show("Clicked!"));
    
	
	public DiaryView(){
	add(new H1("Hello!!!"));
	}
	
	
	
}
