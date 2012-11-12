package view;

import controller.ValidateCredentialsController;
import model.Model;
import view.CredentialsForm;
import junit.framework.TestCase;

public class TestCredentialsForm extends TestCase{

	public void testCredentialsForm () {
		Model model = Model.getModel();
		CredentialsForm cf = new CredentialsForm (model, true);
		ValidateCredentialsController vcc = new ValidateCredentialsController(model, cf, true);

		char[] password = {'3', '2', '1'};
		assertTrue(vcc.credentialsAreValid("Anara Serra", password));
		assertFalse(vcc.credentialsAreValid(null, null));
		
		String username = cf.getUsername();
		password = cf.getPassword();
	}
}
