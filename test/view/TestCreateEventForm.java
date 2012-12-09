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
		
		cef.setNumberOfChoices(1);
		assertEquals(cef.getNumberOfChoices(), 1);
		
		cef.setNumberOfRounds(1);
		assertEquals(cef.getNumberOfRounds(), 1);
		
		cef.setQuestion("test");
		assertEquals(cef.getQuestion(), "test");
		
		cef.redraw();
	}
}
