package controller;

import view.CreateAddSingleChoiceFrame;

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
		String question = "What was the question again?";
		String [] existingChoices = {"Orange","Tomato"};
		
		//AddOpenEventChoice aopEC = new AddOpenEventChoice(eventID, question , existingChoices);
		CreateAddSingleChoiceFrame cascf = new CreateAddSingleChoiceFrame(eventID, question , existingChoices);
		cascf.setVisible(true);
	}
}
