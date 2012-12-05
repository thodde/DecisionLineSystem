package view;

import model.Model;
import junit.framework.TestCase;

public class TestMainForm extends TestCase {
	public void testMainForm() {
		Model model = Model.getModel();
		MainForm mf = new MainForm(model);
		mf.setTextField("test");
		mf.redraw();
		
		assertEquals(mf.getTextField(), "test");
	}
}
