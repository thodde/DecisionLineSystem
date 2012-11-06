package controller;

import model.Model;

/**
 * This class will submit the XML request to create an Open Event
 * @author Trevor Hodde
 */
public class SubmitOpenEventController {
	Model model;
	
	public SubmitOpenEventController(Model m) {
		this.model = m;
	}

	/**
	 * The method submits the new open event to the server and returns the creation status
	 * @param question
	 * @param choiceMode
	 * @param numberOfChoices
	 * @param numberOfRounds
	 * @return String eventID request
	 */
	public String submit(String question, String choiceMode, int numberOfChoices, int numberOfRounds) {
		String eventID = "ABC2"; // Note ValidateEventIDController will accept this string!
		
		// This is where we will interact with the server and receive confirmation that event was accepted by server
		return eventID;
	}
	
}
