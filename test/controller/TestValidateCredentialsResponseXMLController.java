package controller;

import model.DecisionLinesEvent;
import xml.Message;
import junit.framework.TestCase;


public class TestValidateCredentialsResponseXMLController extends TestCase{
	           
	
	public TestValidateCredentialsResponseXMLController	()
	{

	}
	

	
	/**
	 * tests ValidateCredentialsResponseXMLController for User
	 * @author mpeltola
	 */
	public void testValidateCredentialsResponseXMLControllerUser()
	{
		assertTrue (Message.configure("draw2choose.xsd"));
		
		// Position not 0 means user
		
		String testXML1 = "<?xml version='1.0' encoding='UTF-8'?><response id='db845493-9f1c-48b9-b8b2-8edd03833051' success='true'>" +
				"<signInResponse behavior='roundRobin' id='20e71b53-2804-4124-838b-dcea72d4d16a' numChoices='3' numRounds='2' position='1' question='Why Now?' " +
				"type='closed'><choice index='0' value='ABC'/><choice index='1' value='DEF'/><choice index='2' value='GHI'/><user name='MAP'/><user name='Bob'/></signInResponse></response>";

		
		ValidateCredentialsResponseXMLController crxc = new ValidateCredentialsResponseXMLController();
		Message m = new Message(testXML1);
		
		crxc.process(m);
		
		DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
		assertEquals("Why Now?", dle.getQuestion());
		assertEquals("roundRobin", dle.getMode() );
		assertEquals("closed", dle.getType() );
		assertEquals(3, dle.getNumChoices());
		assertEquals(2, dle.getRounds());
		
		assertEquals("ABC", dle.getChoice(0).getChoice());
		assertEquals("DEF", dle.getChoice(1).getChoice());
		assertEquals("GHI", dle.getChoice(2).getChoice());
	
	}
	
	/**
	 * tests ValidateCredentialsResponseXMLController for Moderator
	 * @author mpeltola
	 */
	public void testValidateCredentialsResponseXMLControllerModerator()
	{
		assertTrue (Message.configure("draw2choose.xsd"));

		// Position 0 means moderator
		String testXML1 = "<?xml version='1.0' encoding='UTF-8'?><response id='526968b0-1db1-44ee-b4e4-b9028d41de0d' success='true'><signInResponse behavior='roundRobin' id='20e71b53-2804-4124-838b-dcea72d4d16a' numChoices='3' numRounds='2' position='0' question='Why Now?' type='closed'><choice index='0' value='ABC'/><choice index='1' value='DEF'/><choice index='2' value='GHI'/><user name='MAP'/><user name='Bob'/></signInResponse></response>";
		
		ValidateCredentialsResponseXMLController crxc = new ValidateCredentialsResponseXMLController();
		Message m = new Message(testXML1);
		
		crxc.process(m);
		
		DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
		assertEquals("Why Now?", dle.getQuestion());
		assertEquals("roundRobin", dle.getMode() );
		assertEquals("closed", dle.getType() );
		assertEquals(3, dle.getNumChoices());
		assertEquals(2, dle.getRounds());
		
		assertEquals("ABC", dle.getChoice(0).getChoice());
		assertEquals("DEF", dle.getChoice(1).getChoice());
		assertEquals("GHI", dle.getChoice(2).getChoice());
	
	}
	
}
