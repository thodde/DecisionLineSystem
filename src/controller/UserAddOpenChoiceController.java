package controller;

import view.CreateAddSingleChoiceFrame;

public class UserAddOpenChoiceController {
	public UserAddOpenChoiceController(){
		
	}

	public void setupAddChoiceGUI(String eventID, boolean moderator)
	{
		String question = "What was the question again?";
		String [] existingChoices = {"Orange","Tomato"};
		
		//AddOpenEventChoice aopEC = new AddOpenEventChoice(eventID, question , existingChoices);
		CreateAddSingleChoiceFrame cascf = new CreateAddSingleChoiceFrame(eventID, question , existingChoices);
		cascf.setVisible(true);
	}
}
