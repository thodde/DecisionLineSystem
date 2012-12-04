package view;

import controller.CreateNewEventController;
import model.Model;
import junit.framework.TestCase;

public class TestCreateEventForm extends TestCase {
	public void testCreateEventForm() {
		Model model = Model.getModel();
		CreateEventForm cef = new CreateEventForm(model);
		
		cef.setEventType("Closed");
		assertEquals(cef.getEventType(), "Closed");
		
		cef.setEventType("Open");
		assertEquals(cef.getEventType(), "Open");
		
		cef.setChoiceMode("Round Robin");
		assertEquals(cef.getChoiceMode(), "Round Robin");
		
		cef.setChoiceMode("Asynchronous");
		assertEquals(cef.getChoiceMode(), "Asynchronous");
		
		assertEquals(cef.getNumberOfChoices(), 1);
		
		cef.setNumberOfChoices(0);
		assertEquals(cef.getNumberOfChoices(), 0);
		
		assertEquals(cef.getNumberOfRounds(), 1);
		
		cef.setNumberOfRounds(0);
		assertEquals(cef.getNumberOfRounds(), 0);
		
		cef.setQuestion("test");
		assertEquals(cef.getQuestion(), "");
		
		cef.redraw();
	}
}
