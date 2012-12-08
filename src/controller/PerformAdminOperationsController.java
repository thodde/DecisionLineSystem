package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import model.Model;

/**
 * This controller deals with all of the options specified on the
 * administrator form.
 * @author Trevor Hodde
 */
public class PerformAdminOperationsController implements ActionListener {
	Model model;
	JPanel panel;
	
	public PerformAdminOperationsController(Model m, JPanel p) {
		this.model = m;
		this.panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Create button clicked...");
	}
}
