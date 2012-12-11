package model;

import model.DecisionLinesEvent;
import junit.framework.TestCase;

public class TestCreateDecisionLineEvent extends TestCase {
	public void testDecisionLineEvent() {
		DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
		Line newChoice;
		dle.setQuestion("Why is there air?");
		dle.setNumChoices(4);
		dle.setRounds(3);
		dle.setMode("asynch");
		dle.setType("open");
		dle.setUsername("trevor");
		dle.setPassword("password");
		
		assertEquals(dle.getUsername(), "trevor");
		assertEquals(dle.getPassword(), "password");
		
		assertEquals(dle.getQuestion(), "Why is there air?");
		assertEquals(dle.getRounds(),3);
		assertEquals(dle.getNumChoices(),4);
		
		assertEquals(dle.getType(), "open");
		assertEquals(dle.getMode(), "asynch");
	
		// Valid new position and choice
		newChoice = new Line("Apple", 0);
		dle.setChoice(newChoice);
		
		// Valid new position  and valid choice (Orange should not have been added above)
		newChoice = new Line("Orange", 1);
        dle.setChoice(newChoice);
		
        // Valid new position  and Invalid choice (should have already been added above)
		newChoice = new Line("Apple", 2);
		dle.setChoice(newChoice); 

        // Valid new position  and Invalid choice (should have already been added above)
		newChoice = new Line("Pineapple", 2);
		dle.setChoice(newChoice); 

		// Valid new position  and Invalid choice (should have already been added above)
		newChoice = new Line("Cherry", 3);
		dle.setChoice(newChoice); 
		
		Line choice = dle.getChoice(0);
		assertTrue(choice.getChoice().equals("Apple")); 
		
		choice = dle.getChoice(1);
		assertTrue(choice.getChoice().equals("Orange")); 
		
		choice = dle.getChoice(2);
		assertTrue(choice.getChoice().equals("Pineapple")); 
		
		choice = dle.getChoice(3);
		assertTrue(choice.getChoice().equals("Cherry")); 
		
		int position = dle.getPostion();
	}
}
