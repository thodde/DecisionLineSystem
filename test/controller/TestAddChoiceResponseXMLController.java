package controller;

import xml.Message;
import model.DecisionLinesEvent;
import model.Line;
import junit.framework.TestCase;

public class TestAddChoiceResponseXMLController extends TestCase {
	
	/**
	 * tests controller processing 2 add choice XML response strings
	 * @author mpeltola
	 */
	public void testAddChoiceResponseXMLController(){
		
		assertTrue (Message.configure("draw2choose.xsd"));

		
		DecisionLinesEvent event = DecisionLinesEvent.getInstance();
		event.setEventID("56a78cea-dde5-46ce-9674-e7cad2f9d01d");
		
		event.setNumChoices(2);
		
		String inputXML0  = "<?xml version='1.0' encoding='UTF-8'?><response id='9601df04-64a4-44f9-a016-2b11ef7d5570' success='true'><addChoiceResponse choice='its free' id='56a78cea-dde5-46ce-9674-e7cad2f9d01d' number='0'/></response>";
		String inputXML1  = "<?xml version='1.0' encoding='UTF-8'?><response id='9601df04-64a4-44f9-a016-2b11ef7d5570' success='true'><addChoiceResponse choice='promotes wind' id='56a78cea-dde5-46ce-9674-e7cad2f9d01d' number='1'/></response>";
		
		ValidateCredentialsResponseXMLController crxc = new ValidateCredentialsResponseXMLController();
		
		Message m0 = new Message(inputXML0);
		Message m1 = new Message(inputXML1);
		
		
		
		
		AddChoiceResponseXMLController acrXtrller = new AddChoiceResponseXMLController();
		
		acrXtrller.process(m0);
		acrXtrller.process(m1);
		
		assertEquals("its free" , event.getChoice(0).getChoice());
		assertEquals("promotes wind" , event.getChoice(1).getChoice());
			
		
	}
	
}
