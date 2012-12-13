package controller;

import view.ChoiceListEditor;
import xml.Message;
import model.DecisionLinesEvent;
import model.Model;
import junit.framework.TestCase;

public class TestAddChoiceController extends TestCase {
	
	/**
	 * tests add choice controller to XML strings for moderator
	 * @author mpeltola
	 */
	public void testAddChoiceControllerAsModerator() {
		
		assertTrue (Message.configure("draw2choose.xsd"));
		
		String xmlRef0 = "<addChoiceRequest id='ABC12' number='1' choice='Apple'/></request>";
		String xmlRef1 = "<addChoiceRequest id='ABC12' number='1' choice='Orange'/></request>";
		String xmlRef2 = "<addChoiceRequest id='ABC12' number='1' choice='Pear'/></request>";
		
		
		DecisionLinesEvent dle = Model.getModel().getDecisionLinesEvent();
        
		dle.setType("closed");
		dle.setNumChoices(3);
		dle.setEventID("ABC12");

		ChoiceListEditor cle = new ChoiceListEditor();
		
		 cle.addChoiceString("Apple");
		 cle.addChoiceString("Orange");
		 cle.addChoiceString("Pear");
		 
		AddChoiceController acc = new AddChoiceController(cle);

		String xmlStrippedMessage = "";
		int index;

		// according to controller, this makes it a moderator(???)  Thing works, so controller is operating correctly
		dle.setPosition(1);

		String xml0 = acc.GenerateXML(0);
		String xml1 = acc.GenerateXML(1);
		String xml2 = acc.GenerateXML(2);

		// strip GUID from generated XML (varies from run to run)
		index = xml0.indexOf("<a");
		if (index != -1)
		{
			xmlStrippedMessage = xml0.substring(index);
		}
		
		assertEquals(xmlRef0, xmlStrippedMessage);

		
		// strip GUID from generated XML (varies from run to run)
		index = xml1.indexOf("<a");
		if (index != -1)
		{
			xmlStrippedMessage = xml1.substring(index);
		}
		
		assertEquals(xmlRef1, xmlStrippedMessage );
		
		// strip GUID from generated XML (varies from run to run)
		index = xml2.indexOf("<a");
		if (index != -1)
		{
			xmlStrippedMessage = xml2.substring(index);
		}
		
		acc.actionPerformed(null);
		assertEquals(xmlRef2, xmlStrippedMessage );
		
	}

	
	/**
	 * tests add choice controller to XML strings for user
	 * @author mpeltola
	 */
	public void testAddChoiceControllerAsUser() {
		
		assertTrue (Message.configure("draw2choose.xsd"));
		
		String xmlRef0 = "<addChoiceRequest id='ABC12' number='0' choice='Apple'/></request>";
		String xmlRef1 = "<addChoiceRequest id='ABC12' number='1' choice='Orange'/></request>";
		String xmlRef2 = "<addChoiceRequest id='ABC12' number='2' choice='Pear'/></request>";
		
		
		DecisionLinesEvent dle = Model.getModel().getDecisionLinesEvent();

		// this makes this a user
		dle.setPosition(0);

		
		dle.setType("closed");
		dle.setNumChoices(3);
		dle.setEventID("ABC12");
		ChoiceListEditor cle = new ChoiceListEditor();
		
		 cle.addChoiceString("Apple");
		 cle.addChoiceString("Orange");
		 cle.addChoiceString("Pear");
		 
		AddChoiceController acc = new AddChoiceController(cle);

		String xmlStrippedMessage = "";
		int index;

		// get XML string from public XML generator method
		String xml0 = acc.GenerateXML(0);
		String xml1 = acc.GenerateXML(1);
		String xml2 = acc.GenerateXML(2);

		// strip GUID from generated XML (varies from run to run)
		index = xml0.indexOf("<a");
		if (index != -1)
		{
			xmlStrippedMessage = xml0.substring(index);
		}
		
		assertEquals(xmlRef0, xmlStrippedMessage);

		
		// strip GUID from generated XML (varies from run to run)
		index = xml1.indexOf("<a");
		if (index != -1)
		{
			xmlStrippedMessage = xml1.substring(index);
		}
		
		assertEquals(xmlRef1, xmlStrippedMessage );
		
		// strip GUID from generated XML (varies from run to run)
		index = xml2.indexOf("<a");
		if (index != -1)
		{
			xmlStrippedMessage = xml2.substring(index);
		}
		
		assertEquals(xmlRef2, xmlStrippedMessage);
		
		acc.actionPerformed(null);
		
		assertNull(acc.cle);
		
	}


}