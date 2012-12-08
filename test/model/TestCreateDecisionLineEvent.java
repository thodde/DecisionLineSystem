package model;

import junit.framework.TestCase;

public class TestCreateDecisionLineEvent extends TestCase {
	public void testDecisionLineEvent() {
		String testMode = "asynch";
		String testType = "open";
		
        String testQuestion = "Why is there air?"; 
		DecisionLinesEvent  dle = Model.getModel().getDecisionLinesEvent();
		dle.setQuestion(testQuestion);
		dle.setNumChoices(4);
		dle.setRounds(3);
		dle.setMode(testMode);
		dle.setType(testType);
		
		assertEquals(dle.getQuestion(), testQuestion);
		assertEquals(dle.getRounds(),3);
		assertEquals(dle.getNumChoices(),4);
		
		assertEquals(dle.getType(), testType);
		assertEquals(dle.getMode(), testMode);
	
		/*
		 * These are not valid test cases anymore because setChoice does not return anything
		 * 
		// Valid new position and choice
		assertEquals(dle.setChoice(0, "Apple"), true );
		
		// Invalid new position (out of range) and valid choice
        assertEquals(dle.setChoice(55, "Orange"), false );

        // Invalid new position (position in use) and valid choice
		assertEquals(dle.setChoice(0, "Orange"), false );

		// Valid new position  and valid choice (Orange should not have been added above)
        assertEquals(dle.setChoice(1, "Orange"), true );
		
        // Valid new position  and Invalid choice (should have already been added above)
		assertEquals(dle.setChoice(2, "Apple"), false ); 

        // Valid new position  and Invalid choice (should have already been added above)
		assertEquals(dle.setChoice(2, "Pineapple"), true ); 

		// Valid new position  and Invalid choice (should have already been added above)
		assertEquals(dle.setChoice(3, "Cherry"), true ); 
		*/
		
		String choice = dle.getChoice(0);
		assertEquals(choice, "Apple"); 
		
		choice = dle.getChoice(1);
		assertEquals(choice, "Orange");
		
		choice = dle.getChoice(2);
		assertEquals(choice, "Pineapple");
		
		choice = dle.getChoice(3);
		assertEquals(choice, "Cherry"); 
		
		// out of range check 1
		choice = dle.getChoice(4);
		assertEquals(choice, null); 

		// out of range check 2
		choice = dle.getChoice(-2);
		assertEquals(choice, null); 
	}
}
