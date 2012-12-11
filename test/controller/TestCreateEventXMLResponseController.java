package controller;

import model.Access;
import view.CreateEventForm;
import xml.Message;
import junit.framework.TestCase;

public class TestCreateEventXMLResponseController extends TestCase {

	public void testCreateEventResponse() {
		CreateNewEventController cer = new CreateNewEventController(new CreateEventForm());
		CreateEventResponseXMLController cerx = new CreateEventResponseXMLController();
		
		Message.configure("draw2choose.xsd");
		String request = Message.requestHeader() + "<createRequest behavior='roundRobin' numChoices='2' numRounds='1' question='test?' type='closed'><user name='trevor' password=''/></createRequest></request>";
		Message m = new Message(request);
		//cerx.process(m);
	}
}
