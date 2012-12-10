package controller;

import junit.framework.TestCase;
import model.DecisionLinesEvent;
import model.Model;
import view.CredentialsForm;

public class TestValidateCredentialsController  extends TestCase{
	
	Model m;
	DecisionLinesEvent event;
	ValidateCredentialsController vcc; 

	public TestValidateCredentialsController()
	{
		m = Model.getModel();
		event = m.getDecisionLinesEvent();

		CredentialsForm cf = new CredentialsForm(event);

		vcc = new ValidateCredentialsController(cf);
	}

	
	public void testNewEvent()
	{
		String expected = "<createRequest behavior='roundRobin' type='closed' question='Why is there air?' numChoices='3' numRounds='2'><user name='MAP' password='123'/>";
		event.type = "closed";
		event.rounds = 2;
		event.setNumChoices(3);
		event.mode = "roundRobin";
		event.question = "Why is there air?";

		char [] password = {'1','2','3'};
		vcc.GenerateRequest("MAP", password, true, event, "www");
		String generatedXML = vcc.GetGeneratedRequest();
		
		// get XML string from public XML generator method
		String xmlStrippedMessage = "";

		// strip GUID from generated XML (varies from run to run)
		int index = generatedXML.indexOf("<c");
		if (index != -1)
		{
			xmlStrippedMessage = generatedXML.substring(index);
			index = xmlStrippedMessage.indexOf("</");
			if (index != -1)
			{
				xmlStrippedMessage = xmlStrippedMessage.substring(0, index);
			}
		}
		//System.out.println("T "+xmlStrippedMessage);
		//System.out.println("E "+expected);
        
		assertEquals(xmlStrippedMessage, expected);
	}

	
	public void testSignInRequest()
	{
		String expected = "<signInRequest id='www'><user name='MAP' password='123'/>";
		event.type = "closed";
		event.rounds = 2;
		event.setNumChoices(3);
		event.mode = "roundRobin";
		event.question = "Why is there air?";

		char [] password = {'1','2','3'};
		vcc.GenerateRequest("MAP", password, false, event, "www");
		String generatedXML = vcc.GetGeneratedRequest();
		
		// get XML string from public XML generator method
		String xmlStrippedMessage = "";
		
		// strip GUID from generated XML (varies from run to run)
		int index = generatedXML.indexOf("<s");
		if (index != -1)
		{
			xmlStrippedMessage = generatedXML.substring(index);
			index = xmlStrippedMessage.indexOf("</");
			if (index != -1)
			{
				xmlStrippedMessage = xmlStrippedMessage.substring(0, index);
			}
		}

		//System.out.println("T "+xmlStrippedMessage);
		//System.out.println("E "+expected);

		assertEquals(xmlStrippedMessage, expected);
	}
}
