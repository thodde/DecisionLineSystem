package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class MoveToEdgeController implements ActionListener {
	Model model;
	
	public MoveToEdgeController(Model m) {
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		//removeCreateEventPanel();

		//String eventID = submitClosedEventController.submit(questionTextField.getText(), 
		//		rdbtnRoundRobin.isSelected(),
		//		numberOfChoicesListener.getCurrentValue(),
		//		numberOfRoundsListener.getCurrentValue(),
		//		choiceListEditor.getChoices() );

//		if (eventID.length() > 0) {
//			setupAddEdgeGUI(eventID, true);
//		}
	}

}
