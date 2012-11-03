package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import view.AdminForm;
import view.CreateEventForm;
import view.CredentialsForm;
import model.Model;

/**
 * This class handles what happens when the various buttons are pressed on the main form
 * @author Trevor Hodde
 */
public class ButtonController implements ActionListener {
	/* The following numbers are used to determine different buttons throughout the application */
	final int MODERATOR_BUTTON_VALUE = 0;
	final int USER_BUTTON_VALUE = 1;
	final int ADMIN_BUTTON_VALUE = 2;
	final int EXIT_BUTTON_VALUE = 3;
	
	/** The box being controlled. */
	final int number;
	
	/** model being manipulated. */
	Model model;
	
	/** view under management. */
	JFrame frame;
	
	/** Constructor records all information. */
	public ButtonController(Model m, int n, JFrame f) {
		model = m;
		frame = f;
		number = n;
	}

	/** Take action when pressing a button. */
	public void actionPerformed(ActionEvent e) {
		switch(number) {
		case MODERATOR_BUTTON_VALUE:
			//do moderator stuff
			setupEventOptions();
			break;
		case USER_BUTTON_VALUE:
			//do user stuff
			loadCredentialsForm();
			break;
		case ADMIN_BUTTON_VALUE:
			//do administrative stuff
			loadAdminForm();
			break;
		case EXIT_BUTTON_VALUE:
			//Exit
			frame.dispose();
			break;
		default:
			break;
		}
	}
	
	/**
	 * This stuff happens when the user button is clicked
	 */
	public void loadCredentialsForm() {
		CredentialsForm cf = new CredentialsForm(model, false);
		cf.setVisible(true);
	}
	
	/**
	 * This stuff happens when the moderator button is clicked
	 */
	public void setupEventOptions() {
		CreateEventForm cef = new CreateEventForm(model);
		cef.setVisible(true);
	}
	
	/**
	 * This stuff happens when the administrator button is clicked
	 */
	public void loadAdminForm() {
		AdminForm af = new AdminForm(model);
		af.setVisible(true);
	}
}