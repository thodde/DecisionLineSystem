package controller;

import java.awt.event.ActionEvent;
import view.CreateEventForm;

import model.Model;
import junit.framework.TestCase;

public class TestCreateNewEventController extends TestCase {
	public void testCreateNewEventController() {
		Model model = Model.getModel();
		CreateNewEventController controller = new CreateNewEventController(model, new CreateEventForm(model));
		controller.actionPerformed(new ActionEvent(this, 0, "test"));
		controller.loadCredentialsForm();
	}
}
