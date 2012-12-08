package controller;

import model.DecisionLinesEvent;
import model.Model;
import junit.framework.TestCase;

public class TestAddChoiceController extends TestCase {
	public void testAddChoiceController() {
		DecisionLinesEvent dle = Model.getModel().getDecisionLinesEvent();
		dle.setType("open");
		dle.setType("closed");
	}
}
