package controller;

import model.DecisionLinesEvent;
import model.Model;
import view.ChoiceListEditor;
import junit.framework.TestCase;

public class TestAddChoiceController extends TestCase {
	public void testAddChoiceController() {
		AddChoiceController acc = new AddChoiceController(new ChoiceListEditor());
		DecisionLinesEvent dle = Model.getModel().getDecisionLinesEvent();
		dle.setType("open");
		dle.setType("closed");
	}
}
