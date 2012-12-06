package controller;

import model.DecisionLinesEvent;
import view.ChoiceListEditor;
import junit.framework.TestCase;

public class TestAddChoiceController extends TestCase {
	public void testAddChoiceController() {
		AddChoiceController acc = new AddChoiceController(new ChoiceListEditor(false));
		DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
		dle.setType("open");
		dle.setType("closed");
	}
}
