package view;

import model.Model;
import junit.framework.TestCase;

public class TestAdminForm extends TestCase {
	public void testAdminForm() {
		Model model = Model.getModel();
		AdminForm af = new AdminForm(model);
	}
}
