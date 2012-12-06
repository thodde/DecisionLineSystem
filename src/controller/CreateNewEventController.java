package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
	public DecisionLinesEvent dle;

	/**
	 * Constructor to set up a new event
	 * @param m : Model object
	 * @param f : CreateEventForm object
	 */
	public CreateNewEventController(Model m, CreateEventForm f) {
		this.model = m;
		this.frame = f;
		dle = DecisionLinesEvent.getInstance();
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
		
		dle.setMode(choiceMode);
		dle.setQuestion(question);
		dle.setType(eventType);
		dle.setRounds(numRounds);
		dle.setNumChoices(numChoices);
		model.setDecisionLinesEvent(dle);
		
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
		ChoiceListEditor cle = new ChoiceListEditor(true);
		cle.setVisible(true);
	}
}
