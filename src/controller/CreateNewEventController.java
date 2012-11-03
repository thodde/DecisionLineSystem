package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import model.Model;
import view.AddOpenEventChoice;
import view.ChoiceListEditor;
import view.CreateEventForm;
import view.CredentialsForm;

/**
 * This class handles the events from the event options page from the moderator
 * and it sets up the credentials form.
 * @author Trevor Hodde
 */
public class CreateNewEventController implements ActionListener {
	Model model;
	CreateEventForm frame;
	String question;
	String eventType;
	String choiceMode;
	int numChoices;
	int numRounds;
	SubmitOpenEventController submitOpenEventController;

	public CreateNewEventController(Model m, CreateEventForm f) {
		this.model = m;
		this.frame = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		question = frame.getQuestion();
		eventType = frame.getEventType();
		choiceMode = frame.getChoiceMode();
		numChoices = frame.getNumberOfChoices();
		numRounds = frame.getNumberOfRounds();
		
		//if the moderator has chosen an open event, set it up
		if (eventType.equals("Open")) {
			loadCredentialsForm();
		}
		else {
			getChoices();
		}
	}
	
	public void submitOpenEvent() {
		String eventID = submitOpenEventController.submit(question, choiceMode, numChoices, numRounds);
		
		if (eventID.length() > 0) {
			Vector<String> existingChoices = new Vector<String>();
			existingChoices.add("Choice1");
			existingChoices.add("Choice2");
			AddOpenEventChoice addOpenEventChoice = new AddOpenEventChoice(eventID, question, existingChoices, model);
			addOpenEventChoice.setBounds(1, 40, 450, 430);
		}
	}
	
	public void loadCredentialsForm() {
		Model model = new Model();
		CredentialsForm cf = new CredentialsForm(model, true);
		cf.setVisible(true);
	}
	
	public void getChoices() {
		Vector<String> existingChoices = new Vector<String>();
		existingChoices.add("Choice1");
		existingChoices.add("Choice2");
		ChoiceListEditor cle = new ChoiceListEditor("Choices", existingChoices, true, model);
		cle.setVisible(true);
	}
}
