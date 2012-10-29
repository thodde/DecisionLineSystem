package DLS.Controller.View;

import DLS.view.CreateEvent;
import DLS.view.ExistingEventStatus;
import DLS.view.MainForm;

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
		MainForm mf = MainForm.getMainForm();		
		ExistingEventStatus ees = new ExistingEventStatus(eventID);
		
		// these are place keepers
		// have not implemented real GUI yet
		ees.setVisible(true);
		mf.add(ees);
		mf.setTitle("Decision Lines - Modify Existing Event NEEDS WORK!!!");

		mf.updateStatus(true, "Modify Existing Event NEEDS WORK!!!");
		mf.showCredentialsPanel(true);				
	}
}
