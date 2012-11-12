package view;

import java.util.Vector;

import model.Model;
import junit.framework.TestCase;

public class TestChoiceListEditor extends TestCase {
	public void testChoiceListEditor() {
		Model model = Model.getModel();
		String title = "test";
		Vector<String> list = new Vector<String>();
		
		ChoiceListEditor cle = new ChoiceListEditor(title, list, false, 1, model);
		cle.addTextToChoices();
		list = cle.getChoices();
		cle.loadCredentialsForm();
	}
}
