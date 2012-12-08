package view;

import model.Model;
import junit.framework.TestCase;

public class TestCreateEventForm extends TestCase {
	public void testCreateEventForm() {
		Model model = Model.getModel();
		CreateEventForm cef = new CreateEventForm();
		
		cef.setEventType("closed");
		assertEquals(cef.getEventType(), "closed");
		
		cef.setEventType("open");
		assertEquals(cef.getEventType(), "open");
		
		cef.setChoiceMode("roundRobin");
		assertEquals(cef.getChoiceMode(), "roundRobin");
		
		cef.setChoiceMode("asynchronous");
		assertEquals(cef.getChoiceMode(), "asynchronous");
		
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
