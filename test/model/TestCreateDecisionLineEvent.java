package model;

import model.Model;
import model.DecisionLinesEvent;
import junit.framework.TestCase;

public class TestCreateDecisionLineEvent extends TestCase {
	public void testDecisionLineEvent() {
		DecisionLinesEvent  dle = Model.getModel().getDecisionLinesEvent();
		Model.getModel().setDecisionLinesEvent(dle);
		dle.setQuestion("Why is there air?");
		dle.setNumChoices(4);
		dle.setRounds(3);
		dle.setMode("asynch");
		dle.setType("open");
		
		assertEquals(dle.getQuestion(), "Why is there air?");
		assertEquals(dle.getRounds(),3);
		assertEquals(dle.getNumChoices(),4);
		
		assertEquals(dle.getType(), "open");
		assertEquals(dle.getMode(), "asynch");
	
		// Valid new position and choice
		dle.setChoice(0, "Apple");
		
		// Valid new position  and valid choice (Orange should not have been added above)
        dle.setChoice(1, "Orange");
		
        // Valid new position  and Invalid choice (should have already been added above)
		dle.setChoice(2, "Apple"); 

        // Valid new position  and Invalid choice (should have already been added above)
		dle.setChoice(2, "Pineapple"); 

		// Valid new position  and Invalid choice (should have already been added above)
		dle.setChoice(3, "Cherry"); 
		
		String choice = dle.getChoice(0);
		assertEquals(choice, "Apple"); 
		
		choice = dle.getChoice(1);
		assertEquals(choice, "Orange");
		
		choice = dle.getChoice(2);
		assertEquals(choice, "Pineapple");
		
		choice = dle.getChoice(3);
		assertEquals(choice, "Cherry"); 
	}
}
