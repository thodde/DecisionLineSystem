package controller;

import model.Model;
import junit.framework.TestCase;

public class TestSubmitOpenEventController extends TestCase {
	public void testSubmitClosedEventController() {
		Model model = new Model(); 
		SubmitOpenEventController soec = new SubmitOpenEventController(model);
		soec.submit("test", "Open", 1, 1);
	}
}