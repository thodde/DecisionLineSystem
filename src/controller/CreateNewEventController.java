package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DecisionLinesEvent;
import model.Model;
import view.ChoiceListEditor;
import view.CreateEventForm;
import view.CredentialsForm;

/**
 * This class handles the events from the event options page from the moderator
 * and it sets up the credentials form.
 * @author Trevor Hodde
 */
public class CreateNewEventController implements ActionListener {
	public Model model;
	public CreateEventForm frame;
	DecisionLinesEvent event;

	/**
	 * Constructor to set up a new event
	 * @param m : Model object
	 * @param f : CreateEventForm object
	 */
	public CreateNewEventController(CreateEventForm f) {
		this.model = Model.getModel();
		this.frame = f;
		//dle = Model.getModel().getDecisionLinesEvent();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//get references to all the needed info from the last form
		String question = frame.getQuestion();
		String eventType = frame.getEventType();
		String choiceMode = frame.getChoiceMode();
		int numChoices = frame.getNumberOfChoices();
		int numRounds = frame.getNumberOfRounds();
		
		if((eventType.equalsIgnoreCase("open")) && (numChoices > 1)) {
			JOptionPane.showMessageDialog(null, "Each user gets only 1 choice for open events.\n" +
					"Setting Number of Choices to 1...");
			numChoices = 1;
		}
		
		event = new DecisionLinesEvent();
		event.setMode(choiceMode);
		event.setQuestion(question);
		event.setType(eventType);
		event.setRounds(numRounds);
		event.setNumChoices(numChoices);
		// no, you cannot set this here.  You have to submit it to the server
		//model.setDecisionLinesEvent(event);
		
		//hide the event setup form
		frame.dispose();

		getChoices();
	}
	
	/**
	 * Use a vector to store the moderators choices and populate a JList with the
	 * choices as new choices are added
	 */
	public void getChoices() {
		//load up the choice editor so the moderator can add/remove choices
		CredentialsForm cf = new CredentialsForm(event);
		//ChoiceListEditor cle = new CredentialsForm(true);
		cf.setVisible(true);
	}
}
