package view;

//Klasse wird von romap1 bearbeitet.
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class DiaryView extends VerticalLayout {

	
    
	
	public DiaryView(){
	add(new H1("Hello!!!"));

	public DiaryView() {
		add(new H1("Bla bla bla bla"));
	}
	Button button = new Button("Hello", event -> Notification.show("Clicked!"));
}
	
	
	

