package controller;

import model.Access;
import view.CreateEventForm;
import xml.Message;
import junit.framework.TestCase;

public class TestCreateEventXMLResponseController extends TestCase {

	/**
	 * tests createEventResponseXMLController
	 * @author mpeltola
	 */
	public void testCreateEventResponse() {

		String ref = "<signInRequest id='327f3beb-314c-4f73-99b9-3123bff0af38'><user name='' password=''/></signInRequest></request>";
		
		CreateEventResponseXMLController cerx = new CreateEventResponseXMLController();
		
		Message.configure("draw2choose.xsd");
		
		String request = "<?xml version='1.0' encoding='UTF-8'?><response id='f2711c7a-1a60-4578-bcf4-e55d952e8d6c' success='true'><createResponse id='327f3beb-314c-4f73-99b9-3123bff0af38'/></response>";
		
		Message m = new Message(request);
		cerx.generateXML(m);
		
		String xmlStrippedMessage = "";
		int index;

		// strip GUID from generated XML (varies from run to run)
		index = cerx.xmlString.indexOf("<s");
		if (index != -1)
		{
			xmlStrippedMessage = cerx.xmlString.substring(index);
		}		
		
		assertEquals(ref, xmlStrippedMessage);
	}
}
