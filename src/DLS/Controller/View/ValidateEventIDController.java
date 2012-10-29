package DLS.Controller.View;


//====================================================================
//This class provides the controller operation to validate an 
// event ID with the server.  It is stubbed out to  return a true
// for a small set of strings
//Rev 1  -M. Peltola   26-Oct-2012 Class created 
//====================================================================	
public class ValidateEventIDController {
	
	//====================================================================
	//The constructor for the controller which validates
	// eventIDs with the server 
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================	
	public ValidateEventIDController(){
		
	}

	//====================================================================
	//The method validates the eventID with the server
	// stubbed out for now 
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================	
	public boolean isValidEventID(String eventID)
	{
		boolean valid = false;

		// Replace code below with code to validate eventID with server here
		if (eventID.contains("ABC1") ||eventID.contains("ABC2") ||eventID.contains("ABC3") ||eventID.contains("ABC4"))
		{
			valid = true;
		}


		return  valid;
	}
	
}
