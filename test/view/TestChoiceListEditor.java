package view;

import java.awt.List;

import junit.framework.TestCase;

public class TestChoiceListEditor extends TestCase {
	public void testChoiceListEditor() {
		String title = "test";
		List list = new List();
		
		ChoiceListEditor cle = new ChoiceListEditor();
		cle.addTextToChoices();
		list = cle.getChoices();
	}
}
