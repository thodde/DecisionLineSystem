package controller;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import junit.framework.TestCase;

public class TestButtonController extends TestCase {
	public void testButtonController() {
		ButtonController bc0 = new ButtonController(0, new JFrame());
		ButtonController bc2 = new ButtonController(2, new JFrame());
		ButtonController bc3 = new ButtonController(3, new JFrame());
		
		bc0.loadAdminForm();
		bc0.setupEventOptions();
		
		bc0.actionPerformed(new ActionEvent(this, 0, "test"));
		bc2.actionPerformed(new ActionEvent(this, 2, "test"));
		bc3.actionPerformed(new ActionEvent(this, 3, "test"));
	}
}
