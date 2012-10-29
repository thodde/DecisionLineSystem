package DLS.Controller.View;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;



import DLS.view.CreateEvent;

//====================================================================
//This class provides the class to listen a txt box
// tied to the jlist control
//Rev 1  -M. Peltola   28-Oct-2012 Class created 
//====================================================================	
public class JListTxtFriendListener implements KeyListener
{
	private JList associatedJL;
	
	//====================================================================
	//The constructor does the work of setting up the JList
	//txt box listener 
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	
	public JListTxtFriendListener(JList  jl)
	{
		associatedJL = jl;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		JTextField tf = (JTextField) arg0.getSource();
		int j = associatedJL.getSelectedIndex();

		
		}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		JTextField tf = (JTextField) arg0.getSource();
		int j = associatedJL.getSelectedIndex();

		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		JTextField tf = (JTextField) arg0.getSource();
		int j = associatedJL.getSelectedIndex();

		
	}
}