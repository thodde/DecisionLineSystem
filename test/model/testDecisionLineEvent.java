package model;

import junit.framework.TestCase;

public class testDecisionLineEvent extends TestCase{
	
	public void testDecisionLineEvent()
	{

		DecisionLinesEvent  dle = new DecisionLinesEvent (3,4, true, false);
		
		assertEquals(dle.getNumberOfRounds(),3);
		assertEquals(dle.getNumberOfChoices(),4);
		assertEquals(dle.isClosedEvent(),true);
		assertEquals(dle.isRoundRobinEvent(),false);
		
		assertEquals(dle.setChoice(0, "Apple"), true );
		assertEquals(dle.setChoice(55, "Orange"), false );
		assertEquals(dle.setChoice(0, "Orange"), false );
		assertEquals(dle.setChoice(1, "Apple"), false ); 
			
			
		
	}

}
