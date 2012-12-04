package controller;

import java.util.Vector;

import model.DecisionLinesEvent;
import model.Model;

import view.ChoiceListEditor;
import junit.framework.TestCase;

public class TestAddChoiceController extends TestCase {
	public void testAddChoiceController() {
		AddChoiceController acc = new AddChoiceController(new ChoiceListEditor("test", new Vector<String>(), false, 0, Model.getModel()));
		DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
		dle.setType("open");
		dle.setType("closed");
	}
}
