package view;

import java.awt.List;
import junit.framework.TestCase;

public class TestChoiceListEditor extends TestCase {
	public void testChoiceListEditor() {
		ChoiceListEditor cle = new ChoiceListEditor();
		cle.addTextToChoices();
		
		List list = cle.getChoices();
	}
}
