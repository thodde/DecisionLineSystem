package view;

import controller.ValidateCredentialsController;
import model.Model;
import view.CredentialsForm;
import junit.framework.TestCase;

public class TestCredentialsForm extends TestCase{

	public void testCredentialsForm () {
		Model model = Model.getModel();
		CredentialsForm cf = new CredentialsForm (Model.getModel().getDecisionLinesEvent().getEventID());
		ValidateCredentialsController vcc = new ValidateCredentialsController(cf);

		char[] password = {'3', '2', '1'};
		assertTrue(vcc.credentialsAreValid("Anara Serra", password));
		
		String username = cf.getUsername();
		password = cf.getPassword();
	}
}
