package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.ExistingEventController;
import controller.UserAddOpenChoiceController;
import controller.ValidateEventIDController;

import model.Model;

public class WelcomePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JTextField textEventIDField;

	UserAddOpenChoiceController userAddOpenChoiceController;
	ExistingEventController existingEventController;	
	ValidateEventIDController validateEventIDController;
	
	public WelcomePanel(Model m) {
		createControllers();
	}	

	private void createControllers()
	{
		userAddOpenChoiceController = new UserAddOpenChoiceController();
		existingEventController = new ExistingEventController();
		validateEventIDController = new ValidateEventIDController();
	}
}

