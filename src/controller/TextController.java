package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainForm;
import model.Model;

public class TextController implements ActionListener {

	Model model;
	final MainForm mf;
	
	public TextController(Model model, MainForm mf) {
		this.model = model;
		this.mf = mf;
	}
//cw
	public void actionPerformed(ActionEvent ae) {
		String eventId = mf.getTextField();
		generateEventFromId(eventId);
	}
	
	void generateEventFromId(String eventId) {
		if (eventId.equalsIgnoreCase("ABC")) {
			System.out.println("Got it! " + eventId);
			model.setEventID(eventId);
			mf.redraw();
		} 
		else {
			System.out.println("No Event ID");
		}
		
		
		// clear text once done.
		mf.setTextField("");
	}
}