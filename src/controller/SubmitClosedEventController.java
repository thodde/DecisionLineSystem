package controller;

import model.Model;

public class SubmitClosedEventController {
	Model model;
	//====================================================================
	//The constructor creates the controller which submits
	// the new closed event to the server for acceptance
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public SubmitClosedEventController(Model m) {
		this.model = m;
	}	
	//====================================================================
	//The method submits the new closed event to the server and returns 
	// the creation status
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public String submit(String question, boolean isRoundRobin, int numberOfChoices, int numberOfRounds, String[] choices)
	{
		String eventID = "ABC1"; // Note ValidateEventIDController will accept this string!
		// This is where we will interact with the server.
		// NOTE WE CAN'T RECEIVE confirmation unless you use the special ServerAccess IController interface that event was accepted by server
		return eventID;
	}	

}
