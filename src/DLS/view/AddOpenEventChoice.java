package DLS.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import DLS.Controller.View.QuestionListener;
import DLS.Controller.View.SubmitClosedEventController;
import DLS.Controller.View.SubmitOpenEventController;

//====================================================================
//This class provides the GUI elements of the add choice panel
//Rev 1  -M. Peltola   28-Oct-2012 Class created 
//====================================================================	
public class AddOpenEventChoice extends JPanel{
	
	private JTextField questionTextField;
	private JButton btnCreateThisEvent;
	JPanel questionPanel;
	ChoiceListEditor listEditor; 


	//====================================================================
	//The constructor does the work of setting up the UI elements
	//of the add a choice to an open Event Panel 
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public AddOpenEventChoice(String EventID, String question, String [] existingChoices)
	{
		setBounds(1,1,550,555);
		setLayout(null);

		questionPanel = new JPanel();
		questionPanel.setBounds(1, 70, 609, 93);
		questionPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));
		questionPanel.setBorder(BorderFactory.createTitledBorder("Event Question"));
		questionPanel.setLayout(new BorderLayout(0, 0));
		add(questionPanel);

		questionTextField = new JTextField();
		questionTextField.setForeground(Color.BLACK);
		questionTextField.setEnabled(false);
		questionTextField.setText(question);
		questionTextField.repaint();
		
		questionPanel.add(questionTextField, BorderLayout.CENTER);
		questionTextField.setColumns(10);

		
		listEditor = new ChoiceListEditor("Existing Choices", existingChoices, true, true);
		listEditor.setBounds(45, 190, 450, 435);
		add(listEditor);
		
		repaint();
		
		
	}



}
