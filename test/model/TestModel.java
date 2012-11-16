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
	
	public void testID() {
		String id = "test";
		model.setEventID(id);
		
		assertEquals(model.getEventID(), id);
	}
	
	public void testEventType() {
		String id = "test";
		assertFalse(model.isClosedEventType(id));
		assertTrue(model.isClosedEventType("ABC1"));
	}
	
	public void testAddOption() {
		String option = "test";
		model.initOptions(0);
        assertFalse(model.addOption(option));
		model.initOptions(5);
		assertTrue(model.addOption(option));
	}
	
	public void testAddOptions() {
		String[] options = {"test1", "test2"};
		model.addOptions(options);
	}
	
	public void testAddEdge() {
		model.addNewEdge(0, 0, 0);
	}
}