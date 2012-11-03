package controller;

//====================================================================
//This class provides the open event submission controller
//Rev 1  -M. Peltola   28-Oct-2012 Class created 
//====================================================================	
public class SubmitOpenEventController {

	//====================================================================
	//The constructor creates the controller which submits
	// the new open event to the server for acceptance
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public SubmitOpenEventController (){
	
	}

	//====================================================================
	//The method submits the new open event to the server and returns 
	// the creation status
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public String submit(String question, String choiceMode, int numberOfChoices, int numberOfRounds)
	{
		String eventID = "ABC2"; // Note ValidateEventIDController will accept this string!
		// This is where we will interact with the server and receive confirmation that event was accepted by server
		return eventID;
	}
	
}
