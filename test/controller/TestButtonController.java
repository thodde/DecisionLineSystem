package controller;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import model.Model;
import junit.framework.TestCase;

public class TestButtonController extends TestCase {
	public void testButtonController() {
		Model model = Model.getModel();
		ButtonController bc0 = new ButtonController(model, 0, new JFrame());
		ButtonController bc1 = new ButtonController(model, 1, new JFrame());
		ButtonController bc2 = new ButtonController(model, 2, new JFrame());
		ButtonController bc3 = new ButtonController(model, 3, new JFrame());
		assertTrue(bc0.checkValidId());
		
		bc0.loadCredentialsForm();
		bc0.loadAdminForm();
		bc0.setupEventOptions();
		
		bc0.actionPerformed(new ActionEvent(this, 0, "test"));
		bc1.actionPerformed(new ActionEvent(this, 1, "test"));
		bc2.actionPerformed(new ActionEvent(this, 2, "test"));
		bc3.actionPerformed(new ActionEvent(this, 3, "test"));
	}
}
