package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Model;
import controller.ButtonController;

/**
 * This class displays the final choice once the event is finished
 * @author Martti Peltola
 */
public class DisplayFinalChoiceOrderFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	Model model;

	/**
	 * Constructor to set up the final choice form
	 * @param m : Model object
	 */
	public DisplayFinalChoiceOrderFrame(Model m){
		this.model = m;
		setBounds(10,45,625,528);
		setLayout(null);	

		//show the question panel from the event
		JPanel questionPanel = new JPanel();
		questionPanel.setBounds(1, 8, 609, 93);
		questionPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));
		questionPanel.setBorder(BorderFactory.createTitledBorder("Event Question"));
		add(questionPanel);

		questionPanel.setLayout(new BorderLayout(0, 0));

		//display the question that was asked in the event
		JTextField questionTextField = new JTextField();
		questionTextField.setForeground(Color.BLACK);
		questionTextField.setText("What juice should I purchase?");
		questionTextField.setEnabled(false);
		
		JPanel choicesPanel = new JPanel();
		choicesPanel.setBounds(40, 240, 350, 230);
		
		//show the final choice order
		choicesPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		choicesPanel.setBorder(BorderFactory.createTitledBorder("Final Choice Order"));
		add(choicesPanel);

		//populate the choices
		JTextArea ml = new JTextArea();
		ml.setSize(200,140);
	    choicesPanel.add(ml);
	    ml.setText("Mango\nApple\nOrange");

	    //create an exit button
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(372, 491, 89, 23);
		add(btnExit);

		//set the exit button listener
		btnExit.addActionListener(new ButtonController(model, 3, this));
	}
}
