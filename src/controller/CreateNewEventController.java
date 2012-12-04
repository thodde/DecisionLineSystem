package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import model.DecisionLinesEvent;
import model.Model;
import view.ChoiceListEditor;
import view.CreateEventForm;

/**
 * This class handles the events from the event options page from the moderator
 * and it sets up the credentials form.
 * @author Trevor Hodde
 */
public class CreateNewEventController implements ActionListener {
	public Model model;
	public CreateEventForm frame;
	public String question;
	public String eventType;
	public String choiceMode;
	public int numChoices;
	public int numRounds;
	public SubmitOpenEventController submitOpenEventController;
	public DecisionLinesEvent dle;

	/**
	 * Constructor to set up a new event
	 * @param m : Model object
	 * @param f : CreateEventForm object
	 */
	public CreateNewEventController(Model m, CreateEventForm f) {
		this.model = m;
		this.frame = f;
		submitOpenEventController = new SubmitOpenEventController(m);
		dle = DecisionLinesEvent.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//get references to all the needed info from the last form
		question = frame.getQuestion();
		eventType = frame.getEventType();
		choiceMode = frame.getChoiceMode();
		numChoices = frame.getNumberOfChoices();
		numRounds = frame.getNumberOfRounds();
		
		//hide the event setup form
		frame.dispose();
		
		//if the moderator has chosen an open event, set it up
		if (eventType.equalsIgnoreCase("Open")) {
			submitOpenEvent();
		}
		else { //otherwise, allow the moderator to specify the choices
			getChoices();
		}
	}
	
	/**
	 * If the moderator specifies an Open event, let the users add their own choices to the list
	 */
	public void submitOpenEvent() {
		//build a valid event id
		String eventID = submitOpenEventController.submit(question, choiceMode, numChoices, numRounds);
		
		dle.setEventID(eventID);
		dle.setMode(choiceMode);
		dle.setQuestion(question);
		dle.setType(eventType);
		dle.setRounds(numRounds);
		dle.setNumChoices(numChoices);
		
		//assuming the id is valid, add the current choices to the new DecisionLines Event
		if (eventID.length() > 0) {
			Vector<String> existingChoices = new Vector<String>();
			//load up the open event choice form
			ChoiceListEditor cle = new ChoiceListEditor(question, existingChoices, false, numChoices, model);
			cle.setVisible(true);
		}
	}
	
	/**
	 * Use a vector to store the moderators choices and populate a JList with the
	 * choices as new choices are added
	 */
	public void getChoices() {
		Vector<String> existingChoices = new Vector<String>();
		//load up the choice editor so the moderator can add/remove choices
		ChoiceListEditor cle = new ChoiceListEditor("Choices", existingChoices, true, numChoices, model);
		cle.setVisible(true);
	}
}
