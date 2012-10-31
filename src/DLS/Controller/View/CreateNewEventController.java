package DLS.Controller.View;

import DLS.view.CreateEventFrame;
import DLS.view.MainForm;

//====================================================================
//This class provides the controller operation to setup the GUI 
// elements used to create a new event panel
//Rev 1  -M. Peltola   26-Oct-2012 Class created 
//====================================================================	
public class CreateNewEventController {

	//====================================================================
	//The constructor for the controller which sets up the intial
	// GUI elements used to create a new event panel
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	public 	CreateNewEventController ()
	{

	}
	
	//====================================================================
	//This method is the controllers prime mover to setup the GUI
	// used to create an intial new event
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	public void setupAddNewEventGUI()
	{
		MainForm mf = MainForm.getMainForm();		
		CreateEventFrame ce = new CreateEventFrame();

		ce.setVisible(true);
		mf.add(ce);
		mf.setTitle("Decision Lines - Create New Event");

		mf.updateStatus(true, "Create Event");
		mf.showCredentialsPanel(true);	
		
		// last thing you do to clean things up....
		mf.invalidate();
		mf.pack();
		mf.repaint();  // redundant
	}
}
