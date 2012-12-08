package model;

import junit.framework.TestCase;

public class TestCreateDecisionLineEvent extends TestCase{
	
	public void testCreateDecisionLineEvent() {
		DecisionLinesEvent  dle = Model.getModel().getDecisionLinesEvent();
		
		//assertEquals(dle.getRounds(),3);
		//assertEquals(dle.getType(), "Open");
	}
}
