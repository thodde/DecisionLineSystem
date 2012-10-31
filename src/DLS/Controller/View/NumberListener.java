package DLS.Controller.View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import DLS.view.CreateEventFrame;

//====================================================================
//This class provides the controller operation to manage listening to 
// input to a text box accepting integer input
//Rev 1  -M. Peltola   26-Oct-2012 Class created 
//====================================================================	
public class NumberListener implements KeyListener
{
	private CreateEventFrame ce;
	private int minLimit;
	private int maxLimit;
	private int currentValue;


	public NumberListener(int minValue, int maxValue, int initialValue)
	{
		minLimit = minValue;
		maxLimit = maxValue;

		// we could check that the initial value is out of range, but lets trust ourselves
		currentValue = initialValue;
	}

	//====================================================================
	//Returns the current integer value
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	public int getCurrentValue(){
		return currentValue;
	}

	//====================================================================
	// Ensure proposed value is within limits.
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	private boolean limitProtectedSet(int proposedValue)
	{
		boolean changed = false;

		if (proposedValue > maxLimit)
		{
			proposedValue = maxLimit;
			changed = true;
		}
		if (proposedValue < minLimit)
		{
			proposedValue = minLimit;
			changed = true;
		}

		if (proposedValue != currentValue)
		{
			changed = true;
			currentValue = proposedValue;
		}
		return changed;
	}

	//====================================================================
	// update control value after input has been validated
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	private void 	updateValue(KeyEvent arg0)
	{
		JTextField tf = (JTextField) arg0.getSource();
		if(validateNumber(tf.getText()))
		{
			tf.setText(""+currentValue);
		}
	}

	//====================================================================
	// validate text input is a valid number witin limits
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	public boolean validateNumber(String txt)
	{
		boolean changed = false;

		if(txt.length()>0)
		{
			int num = 0;
			try {

				num = Integer.valueOf(txt);

				changed = limitProtectedSet(num);

			} catch (Exception e) {
				// just put old value back in
				changed = false;
			}
		}
		return changed;
	}



	//====================================================================
	// Set numeric value into text box
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	void SetValueIntoControl(JTextField tf, int num)
	{
		tf.setText("" + num);
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//updateValue(arg0);
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		updateValue(arg0);	
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//updateValue(arg0);			
	}


}
