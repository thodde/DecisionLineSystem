package view;

import model.Model;
import junit.framework.TestCase;

public class TestDisplayFinalChoiceOrderForm extends TestCase {
	public void testDisplayFinalChoiceOrderForm() {
		Model model = Model.getModel();
		DisplayFinalChoiceOrderFrame fcof = new DisplayFinalChoiceOrderFrame(model);
	}
}
