package ch.bfh.btx8081.w2019.red.SocialDisorderApp;
import view.ExerciseView;
import view.DiaryView;
import view.ContactView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Shows the Main View with three Buttons
 * @author relgs1
 */
@Route("")
@CssImport("./styles/styles.css")
public class MainView extends VerticalLayout {

    public MainView() {    	
    	// create horizontal layout which is centered
    	HorizontalLayout hLayout = new HorizontalLayout();
    	hLayout.addClassName("center");
    	
    	// image with the app logo
    	Image imgLogo = new Image("./img/ghosty.png", "Ghosty");
    	
    	// labels with the app title
    	Label lblAppTitlePartOne = new Label("Daily");
    	lblAppTitlePartOne.addClassName("lblVertical");
    	Label lblAppTitlePartTwo = new Label("Ghost");
    	lblAppTitlePartTwo.addClassName("lblVertical");
    	
    	// add components to horizontal layout
    	hLayout.add(lblAppTitlePartOne, imgLogo, lblAppTitlePartTwo);
     	
    	// button with link to contact view
     	Button btnContact = new Button("Kontakte", new Icon(VaadinIcon.USER_CARD));
     	btnContact.addClassName("icon50px");
     	btnContact.setIconAfterText(true);
     	btnContact.setWidth("100%");
     	btnContact.setHeight("150px");
     	btnContact.addClickListener(e -> UI.getCurrent().navigate(ContactView.class));
     	
     	// button with link to exercise view
        Button btnExercise = new Button("Übungen", new Icon(VaadinIcon.CHECK_SQUARE_O));
        btnExercise.addClassName("icon50px");
        btnExercise.setIconAfterText(true);
        btnExercise.setWidth("100%");
        btnExercise.setHeight("150px");
        btnExercise.addClickListener(e -> UI.getCurrent().navigate(ExerciseView.class));
        
        // button with link to diary view
        Button btnDiary = new Button("Tagebuch", new Icon(VaadinIcon.CALENDAR));
        btnDiary.addClassName("icon50px");
        btnDiary.setIconAfterText(true);
        btnDiary.setWidth("100%");
        btnDiary.setHeight("150px");
        btnDiary.addClickListener(e -> UI.getCurrent().navigate(DiaryView.class));
        
        // add all components to layout
        add(hLayout, btnContact, btnExercise, btnDiary);
    }
}