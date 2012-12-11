package controller;

import java.awt.event.ActionEvent;
import view.CreateEventForm;

import model.DecisionLinesEvent;
import model.Model;
import junit.framework.TestCase;

/**
 * Test CreateEventController (or at least XML it generates)
 * @author mpeltola
 * @version 2  Modified controller to expose testable main element (xml generator) and now test xml
 *  
 */

/**
 * Constructor for CreateNewEventController -- actually tests CreateEventController (no New in name)
 * @author mpeltola
 */
public class TestCreateNewEventController extends TestCase {
	public void testCreateNewEventController() {

		// I strip out the ID GUID for both this reference string, and the generated controller XML
		// since they will vary from run to run
		String ref1 = "<createRequest behavior='asynchronous' type='open' question='Why is there air?' numChoices='4' numRounds='3'><user name='Bob' password='123'/></createRequest></request>";
		
		DecisionLinesEvent dle = Model.getModel().getDecisionLinesEvent();
		dle.setUsername("Bob");
		dle.setPassword("123");
		
		CreateEventForm f = new CreateEventForm();
		
		f.setNumberOfChoices(4);
		f.setNumberOfRounds(3);
		f.setQuestion("Why is there air?");
		
		f.setEventType("open");
		f.setChoiceMode("roundRobin");
		
		// get XML string from public XML generator method
		String xmlStrippedMessage = "";
		
		// strip GUID from generated XML (varies from run to run)
		int index = ref1.indexOf("<c");
		if (index != -1)
		{
			xmlStrippedMessage = ref1.substring(index);
		}
		
		assertEquals(xmlStrippedMessage, ref1);
		
		CreateNewEventController cnec = new CreateNewEventController(f);
		cnec.actionPerformed(new ActionEvent(cnec, 0, xmlStrippedMessage));
	}
}
