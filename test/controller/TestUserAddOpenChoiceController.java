package controller;

import model.Model;
import junit.framework.TestCase;

public class TestUserAddOpenChoiceController extends TestCase {
	public void testUserAddOpenChoiceController() {
		Model model = new Model();
		UserAddOpenChoiceController controller = new UserAddOpenChoiceController(model);
		controller.setupAddChoiceGUI("test", false);
	}
}
