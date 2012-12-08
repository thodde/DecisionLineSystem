package view;

import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;

import model.Model;
import junit.framework.TestCase;

public class TestChoiceListEditor extends TestCase {
	public void testChoiceListEditor() {
		Model model = Model.getModel();
		String title = "test";
		List list = new List();
		
		ChoiceListEditor cle = new ChoiceListEditor();
		cle.addTextToChoices();
		list = cle.getChoices();
	}
}
