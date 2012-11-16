package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainForm;
import model.Model;

/**
 * This controller handles input from text boxes
 * @author Trevor Hodde
 */
public class TextController implements ActionListener {
	Model model;
	final MainForm mf;
	
	/**
	 * This constructor sets up the text box controller
	 * @param model : Model object
	 * @param mf : MainForm object
	 */
	public TextController(Model model, MainForm mf) {
		this.model = model;
		this.mf = mf;
	}

	/**
	 * Grabs the event ID from the text box when there is a change in text
	 * and then creates a new event from the ID
	 */
	public void actionPerformed(ActionEvent ae) {
		String eventId = mf.getTextField();
		model.getDecisionLinesEvent().setEventID(eventId);
		//generateEventFromId(eventId);
	}
	
	/**
	 * Sets up an event based on the event ID
	 * @param eventId : String
	 */
	/*public boolean generateEventFromId(String eventId) {
		boolean valid;
		//This is a sample ID for testing. Soon this will be replaced with XML controllers
		if (eventId.equalsIgnoreCase("ABC")) {
			model.setEventID(eventId);
			mf.redraw();
			valid = true;
		} 
		else {
			System.out.println("No Event ID");
			valid = false;
		}
		
		// clear text once done.
		mf.setTextField("");
		return valid;
	}*/
}