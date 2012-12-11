package model;

import javax.swing.JFrame;

import junit.framework.TestCase;

public class TestModel extends TestCase {
	static Model model;
	
	public static void testModel() {
		model = null;
		model = Model.getModel();
		
		model = Model.getModel();
		assertNotNull(model);
		
		model.setUsername("trevor");
		String username = model.getUsername();
		assertEquals(username, "trevor");
		
		model.setPassword("password");
		String password = model.getPassword();
		assertEquals(password, "password");
		
		DecisionLinesEvent dle = Model.getModel().getDecisionLinesEvent();
		model.setDecisionLinesEvent(dle);
		
		JFrame tmp = model.getJFrame();
	}
}
