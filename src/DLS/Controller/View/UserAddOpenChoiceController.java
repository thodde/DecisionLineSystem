package DLS.Controller.View;

import DLS.model.Model;
import DLS.view.AddOpenEventChoice;
import DLS.view.EdgeDisplayPanel;
import DLS.view.MainForm;

//====================================================================
//This class provides the controller which sets up the GUI elements 
// for the add choice panel
//Rev 1  -M. Peltola   28-Oct-2012 Class created 
//====================================================================	
public class UserAddOpenChoiceController {

	
	//====================================================================
	//The constructor for the controller which sets up the add choice
	// panel 
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	public UserAddOpenChoiceController(){
		
	}

	//====================================================================
	//This is the controler's invoking methods  which sets up the add choice
	// panel 
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	public void setupAddChoiceGUI(String eventID, boolean moderator)
	{
		MainForm mf = MainForm.getMainForm();
		
		mf.updateStatus(true, "Add open Choice");
		mf.showCredentialsPanel(true);

		mf.setTitle("Decision Lines - Add your choice");
		String question = "What was the question again?";
		String [] existingChoices = {"Orange","Tomato"};
		
		AddOpenEventChoice aopEC = new AddOpenEventChoice(eventID, question , existingChoices);
		
		aopEC.setVisible(true);
		mf.add(aopEC);
	}
}
