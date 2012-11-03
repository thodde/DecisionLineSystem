package controller;

import view.MainForm;
import model.Model;
import junit.framework.TestCase;

public class TestTextController extends TestCase {

	public void testTextWorks () {
		Model model = new Model();
		
		MainForm form = new MainForm(model);
		
		TextController tc = new TextController (model, form);
		tc.generateEventFromId("ABC");
		
		assertEquals (model.getEventID(), "ABC");
	}
	
	public void testTextFails() {
		Model model = new Model();
		
		MainForm form = new MainForm(model);
		
		TextController tc = new TextController (model, form);
		tc.generateEventFromId("ABC");
		
		assertNotSame (model.getEventID(), "123");
	}
}