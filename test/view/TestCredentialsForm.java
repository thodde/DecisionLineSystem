package view;

import controller.ValidateCredentialsController;
import model.Model;
import view.CredentialsForm;
import junit.framework.TestCase;

public class TestCredentialsForm extends TestCase{

	public void testCredentialsForm () {
		Model model = Model.getModel();
		CredentialsForm cf = new CredentialsForm (true);
		ValidateCredentialsController vcc = new ValidateCredentialsController(cf, true);

		char[] password = {'3', '2', '1'};
		//assertFalse(vcc.credentialsAreValid(null, null));
		//assertFalse(vcc.credentialsAreValid("", password));
		assertTrue(vcc.credentialsAreValid("Anara Serra", password));
		
		String username = cf.getUsername();
		password = cf.getPassword();
	}
}
