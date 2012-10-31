package DLS.Controller.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DLS.view.MainForm;

public class MoveToEdgeController implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent arg0) {

		MainForm mf = MainForm.getMainForm();
		//removeCreateEventPanel();

		String eventID = submitClosedEventController.submit(questionTextField.getText(), 
				rdbtnRoundRobin.isSelected(),
				numberOfChoicesListener.getCurrentValue(),
				numberOfRoundsListener.getCurrentValue(),
				choiceListEditor.getChoices() );

		if (eventID.length()>0)
		{
			//removeCreateEventPanel();
			mf.updateStatus(true, "Closed event submitted");

			setupAddEdgeGUI(eventID, true);
		}
	}

}
