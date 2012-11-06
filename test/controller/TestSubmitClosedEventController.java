package controller;

import model.Model;
import junit.framework.TestCase;

public class TestSubmitClosedEventController extends TestCase {
	public void testSubmitClosedEventController() {
		Model model = new Model(); 
		SubmitClosedEventController scec = new SubmitClosedEventController(model);
		String[] choices = {"test1", "test2"};
		scec.submit("test", true, 1, 1, choices);
	}
}
