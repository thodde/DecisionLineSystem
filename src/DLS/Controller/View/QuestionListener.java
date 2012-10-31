package DLS.Controller.View;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;



import DLS.view.CreateEventFrame;

//====================================================================
//This class provides the class to listen to the question txt box
//Rev 1  -M. Peltola   26-Oct-2012 Class created 
//====================================================================	
public class QuestionListener implements KeyListener
{
	private CreateEventFrame ce;
	
	//====================================================================
	//The constructor does the work of setting up the question listener
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================

	public QuestionListener(CreateEventFrame p)
	{
		ce = p;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		JTextField tf = (JTextField) arg0.getSource();
		ce.setValidQuestion(tf.getText().length()>0 && tf.getText().contains("?"));
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		JTextField tf = (JTextField) arg0.getSource();
		ce.setValidQuestion(tf.getText().length()>0 && tf.getText().contains("?"));
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		JTextField tf = (JTextField) arg0.getSource();
		ce.setValidQuestion(tf.getText().length()>0 && tf.getText().contains("?"));
		
	}
}
