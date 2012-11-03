package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ForceEventDecisionController;


public class ExistingEventStatusFrame extends JFrame{
	
	ForceEventDecisionController forceDecision;
	
	public ExistingEventStatusFrame(String eventID){


		setBounds(25,60,550,555);
		setLayout(null);	

	//CredentialsForm cp = new CredentialsForm();
	//add(cp);
	//cp.setVisible(true);		
		
		
	
	JPanel questionPanel = new JPanel();
	questionPanel.setBounds(1, 8, 609, 93);
	questionPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));
	questionPanel.setBorder(BorderFactory.createTitledBorder("Event Question"));
	add(questionPanel);

	questionPanel.setLayout(new BorderLayout(0, 0));

	JTextField questionTextField = new JTextField();
	questionTextField.setForeground(Color.BLACK);
	questionTextField.setText("What juice should I purchase?");
	questionTextField.setEnabled(false);
	
	JPanel statusPanel = new JPanel();
	statusPanel.setBounds(60, 200, 350, 93);
	statusPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));
	statusPanel.setBorder(BorderFactory.createTitledBorder("Event Question"));
	add(statusPanel);
	JLabel Lbl1 = new JLabel("Currently round 3 of 3.  1 Edge remains to be added.");
	
	Lbl1.setBounds(23,  200, 350, 35);
	statusPanel.add(Lbl1);
	
	JButton forceBtn = new JButton("Force Event Decision");
	forceBtn.setBounds(100, 391, 220, 23);
	add(forceBtn);
	
	forceDecision = new ForceEventDecisionController(eventID);
		
	forceBtn.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent arg0) {

			if(forceDecision.forceEvent())
			{
				displayFinalChoices();
				setVisible(false);
			}
		}
	});

	
	JButton btnCancel = new JButton("Cancel");
	btnCancel.setBounds(372, 391, 89, 23);
	add(btnCancel);

	btnCancel.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		}
	});
	
	
	StatusPanel sp = new StatusPanel();
	sp.setBounds(10, 630, 760, 55);
	add(sp);
	sp.setVisible(true);
	
	}
	
	private void displayFinalChoices()
	{
		DisplayFinalChoiceOrderFrame choiceOrder = new DisplayFinalChoiceOrderFrame();
		choiceOrder.setVisible(true);
	}

}
