package DLS.Controller.View;

//!!!IMPORTANT WARNING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//MODIFIED from the professsor's example.  Will write our own if required
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//package distributed.controller.client;



import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import DLS.model.*;
import DLS.view.*;

/**
 * Controller to manage the text views of the model.
 */
public class TextController implements ActionListener {

	/** Element being controlled. */
	Value value;
	
	
	/** When value changes, notify the desired entity */
	public TextController (Value value) {
		this.value = value;
	}
	
	/**
	 * Respond to attempts to change the text field.
	 * 
	 * Convert this into a method invocation that doesn't require user action. 
	 * This method will not be tested automatically. You review this method
	 * by code review post-coverage to validate that it works as intended.
	 */
	public void actionPerformed(ActionEvent ae) {
		JTextField tf = (JTextField) ae.getSource();
		validate (tf);
		
	}
	
	/**
	 * This package-private method is off limits outside of this package,
	 * but it serves the essential purpose of being available for testing.
	 * Through this method you test that changes to TextField result in 
	 * changes to the Value governed by this controller.
	 */
	void validate (JTextField tf) {
		int num = 0;
		try {
			
			num = Integer.valueOf(tf.getText());
			
			// see if we can raise value
			if (num > value.getMaximum()) {
				num = value.getMaximum();
			}				
		 else if (num < value.getMinimum()) {
				// see if we can lower value
				num = value.getMinimum();
				}
						
			
		} catch (Exception e) {
			// just put old value back in
			tf.setText("" + num);
		}
	}
}
