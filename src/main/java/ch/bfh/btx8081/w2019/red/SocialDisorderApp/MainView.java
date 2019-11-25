package ch.bfh.btx8081.w2019.red.SocialDisorderApp;
import view.ExerciseView;
import view.DiaryView;
import view.ContactView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Shows the Main View with three Buttons
 * @author relgs1
 */
@SuppressWarnings("serial")
@Route("")
@CssImport("./styles/styles.css")
public class MainView extends VerticalLayout {

    public MainView() {    	
    	// label with the app title
    	H3 lblAppTitle = new H3("DAILY GHOST");
    	lblAppTitle.addClassName("centered");
    	
    	// label that contains a div and shows a curve under the app title
    	Label lblCurve = new Label();
    	lblCurve.addClassName("curvy");
    	lblCurve.addClassName("centered");
        
    	// image with the app logo
    	Image imgLogo = new Image("./img/ghosty.png", "Ghosty");
    	imgLogo.addClassName("centered");
    	
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
        add(lblAppTitle, lblCurve, imgLogo, btnContact, btnExercise, btnDiary);
    }
}