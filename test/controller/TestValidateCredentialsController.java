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
		String question = "Why is there air?";
		String choiceMode = "roundRobin";
		String eventType = "closed";
		int numChoices = 3;
		int numRounds = 2;

		CredentialsForm cf = new CredentialsForm(question, eventType, choiceMode, numChoices, numRounds);

		vcc = new ValidateCredentialsController(cf);
	}

	
	public void testNewEvent()
	{
		String expected = "<createRequest behavior='roundRobin' type='closed' question='Why is there air?' numChoices='3' numRounds='2'><user name='MAP' password='123'/>";

		String question = "Why is there air?";
		String choiceMode = "roundRobin";
		String eventType = "closed";
		int numChoices = 3;
		int numRounds = 2;

		char [] password = {'1','2','3'};
		vcc.GenerateRequest("MAP", password, true, question, eventType, choiceMode, numChoices, numRounds, "www");
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

		String question = "Why is there air?";
		String choiceMode = "roundRobin";
		String eventType = "closed";
		int numChoices = 3;
		int numRounds = 2;

		char [] password = {'1','2','3'};
		vcc.GenerateRequest("MAP", password, false, question, eventType, choiceMode, numChoices, numRounds, "www");
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
