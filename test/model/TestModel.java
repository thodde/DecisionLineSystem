package model;

import junit.framework.TestCase;

public class TestModel extends TestCase {
	
	public void testAddOption() {
		Model model;
		model = Model.getModel();
		String option = "test";
		model.initOptions(0);
        assertFalse(model.addOption(option));
		model.initOptions(5);
		assertTrue(model.addOption(option));
	}
}
