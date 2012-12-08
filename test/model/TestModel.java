package model;

import junit.framework.TestCase;

public class TestModel extends TestCase {
	static Model model;
	
	public static void testModel() {
		model = null;
		model = Model.getModel();
		
		model = Model.getModel();
		assertNotNull(model);
		
	}
	

}
