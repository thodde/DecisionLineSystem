package controller;

import java.util.Vector;

import model.Model;
import view.ChoiceListEditor;

/**
 * This class allows the users to add a choice when the event is open
 * @author Trevor Hodde
 */
public class UserAddOpenChoiceController {
	Model model;
	
	/**
	 * This constructor sets up the controller to let the user add a choice
	 * in an open event
	 */
	public UserAddOpenChoiceController(Model m){
		this.model = m;
	}

	/**
	 * Create the form where the user can enter their choice(s)
	 * @param eventID : String 
	 * @param moderator : boolean, true if the user is the moderator
	 */
	public void setupAddChoiceGUI(String eventID, boolean moderator) {
		String question = "What was the question again?";
		Vector<String> existingChoices = new Vector<String>();
		//add some fake data for testing
		existingChoices.add("Tomato");
		existingChoices.add("Orange");
		
		//load the add choice form
		ChoiceListEditor cle = new ChoiceListEditor(question, existingChoices, false, 1, model);
		cle.setVisible(true);
	}
}
