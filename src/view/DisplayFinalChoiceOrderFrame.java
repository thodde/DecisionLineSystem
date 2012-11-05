package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DisplayFinalChoiceOrderFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public DisplayFinalChoiceOrderFrame(){

		setBounds(10,45,625,528);
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
		
		JPanel choicesPanel = new JPanel();
		choicesPanel.setBounds(40, 240, 350, 230);
		
		choicesPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		choicesPanel.setBorder(BorderFactory.createTitledBorder("Final Choice Order"));
		add(choicesPanel);

		JTextArea ml = new JTextArea();
		
		ml.setSize(200,140);
	    choicesPanel.add(ml);
	    ml.setText("Mango\nApple\nOrange");

		StatusPanel sp = new StatusPanel();
		sp.setBounds(10, 630, 760, 55);
		add(sp);
		sp.setVisible(true);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(372, 491, 89, 23);
		add(btnExit);

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			
			}
		});
	}
}
