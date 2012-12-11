package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import view.AdminForm;
import view.CreateEventForm;
import view.CredentialsForm;
import view.MainForm;
import model.Model;

/**
 * This class handles what happens when the various buttons are pressed on the main form
 * @author Trevor Hodde
 */
public class ButtonController implements ActionListener {
	/* The following numbers are used to determine different buttons throughout the application */
	final static public int MODERATOR_BUTTON_VALUE = 0;
	final static public int USER_BUTTON_VALUE = 1;
	final static public int ADMIN_BUTTON_VALUE = 2;
	final static public int EXIT_BUTTON_VALUE = 3;
	
	/** The box being controlled. */
	final int number;
	
	/** model being manipulated. */
	Model model;
	
	/** view under management. */
	JFrame frame;
	
	//moved here for JUnit testing purposes
	CredentialsForm cf; 
	CreateEventForm cef;
	AdminForm af;
	
	
	/** Constructor records all information. */
	public ButtonController(int n, JFrame f) {
		model = Model.getModel();
		frame = f;
		number = n;

		// initialize forms
		tearDownForms();

	}
	
	CredentialsForm getCredentialsForm(){
		return cf;
	}

	CreateEventForm getCreateEventForm(){
		return cef;
	}

	AdminForm getAdminForm(){
		return af;		
	}
	
	
	void tearDownForms()
	{
		cf  = null; 
		cef = null;
		af  = null;
	}

	/** Take action when pressing a button. */
	public void actionPerformed(ActionEvent e) {
		switch(number) {
		case MODERATOR_BUTTON_VALUE:
			//handle button clicks that have to do with the moderator
			setupEventOptions();
			break;
		case USER_BUTTON_VALUE:
			//handle button clicks that have to do with the user
			String eventId = ((MainForm)frame).getTextField();
			loadCredentialsForm(eventId);
			break;
		case ADMIN_BUTTON_VALUE:
			//handle button clicks that have to do with the administrator
			loadAdminForm();
			break;
		case EXIT_BUTTON_VALUE:
			//Handle Exit buttons throughout the application
			frame.dispose();
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	/**
	 * This method is called when the user button is clicked
	 * on the MainForm
	 */
	public void loadCredentialsForm(String dleId) {
		//load up the credentials form
		cf = new CredentialsForm(dleId);
		cf.setVisible(true);
	}
	
	/**
	 * This method is called when the moderator button is clicked
	 * on the MainForm
	 */
	public void setupEventOptions() {
		//load up create event form for the moderator
		cef = new CreateEventForm();
		cef.setVisible(true);
	}
	
	/**
	 * This stuff happens when the administrator button is clicked
	 */
	public void loadAdminForm() {
		//load up the administrator form
		af = new AdminForm(model);
		af.setVisible(true);
	}
}