package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DecisionLinesEvent;
import model.Model;
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
	CredentialsForm cf;

	/**
	 * Constructor to set up a new event
	 * @param m : Model object
	 * @param f : CreateEventForm object
	 */
	public CreateNewEventController(CreateEventForm f) {
		this.model = Model.getModel();
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//get references to all the needed info from the last form
		String question = frame.getQuestion();
		String eventType = frame.getEventType();
		String choiceMode = frame.getChoiceMode();
		int numChoices = frame.getNumberOfChoices();
		int numRounds = frame.getNumberOfRounds();
		
		event = new DecisionLinesEvent();
		event.setMode(choiceMode);
		event.setQuestion(question);
		event.setType(eventType);
		event.setRounds(numRounds);
		event.setNumChoices(numChoices);
		
		//hide the event setup form
		frame.dispose();
		
		cf = new CredentialsForm(event);
		cf.setVisible(true);
	}
}
