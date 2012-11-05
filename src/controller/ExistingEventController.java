package controller;

import view.ExistingEventStatusFrame;

//====================================================================
//This class provides the controller operation to setup the GUI 
//elements used by a manage to manage an existing event
//Rev 1  -M. Peltola   28-Oct-2012 Class created 
//====================================================================	
public class ExistingEventController {
	
	//====================================================================
	//The constructor for the controller which sets up the GUI
	// elements used to manage an existing event 
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public ExistingEventController() {
		
	}

	//====================================================================
	//This method is the controller's prime mover to setup the GUI
	// elements to used to manage an existing event
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public void setupExistingEventGUI(String eventID)
	{
		ExistingEventStatusFrame ees = new ExistingEventStatusFrame(eventID);
		ees.setVisible(true);
	}
}
