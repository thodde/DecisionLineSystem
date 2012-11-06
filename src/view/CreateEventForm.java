package view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.border.EmptyBorder;

import controller.ButtonController;
import controller.CreateNewEventController;
import controller.SubmitClosedEventController;
import controller.SubmitOpenEventController;

import model.Model;

/**
 * This class sets up the form that allows the moderator
 * to create a new DecisionLines Event. It is where all
 * the options for an event can be specified
 * @author Trevor Hodde
 */
public class CreateEventForm extends JFrame {
	private static final long serialVersionUID = 1L;
	JTextField textField_NumberOfChoices;
	JTextField textField_NumberOfRounds;
	JTextField questionTextField;
	JButton btnCreateThisEvent;
	JRadioButton rdbtnClosedEvent;
	JRadioButton rdbtnOpenEvent;
	JRadioButton rdbtnAsynch;
	JRadioButton rdbtnRoundRobin;
	ChoiceListEditor choiceListEditor;
	JPanel contentPane;
	
	final ButtonGroup eventTypeButtonGroup;
	final ButtonGroup gamePlayTypeButtonGroup;
	
	SubmitClosedEventController submitClosedEventController;
	SubmitOpenEventController submitOpenEventController;

	JPanel questionPanel;

	boolean validQuestion;
	boolean validNumOfChoices;
	boolean validNumOfRounds;
	final int maxChoice = 10;	
	final int maxRounds = 8;
	Model model;

	public CreateEventForm(Model m) {
		this.model = m;
		//Set up the form that will hold all the controls
		setTitle("Create a Decision Lines Event");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(630, 580);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//add the text box for the question to be added
		questionPanel = new JPanel();
		questionPanel.setBounds(1, 8, 609, 93);
		questionPanel.setBorder(BorderFactory.createTitledBorder("Event Question"));
		add(questionPanel);

		questionPanel.setLayout(new BorderLayout(0, 0));

		questionTextField = new JTextField();
		questionTextField.setForeground(Color.BLACK);

		questionPanel.add(questionTextField, BorderLayout.CENTER);
		questionTextField.setColumns(10);
		
		//create two separate button groups for event types and game play types to be determined
		eventTypeButtonGroup = new ButtonGroup();
		gamePlayTypeButtonGroup = new ButtonGroup();

		JPanel eventTypePanel = new JPanel();
		eventTypePanel.setBounds(11, 114, 129, 76);
		eventTypePanel.setBorder(BorderFactory.createTitledBorder("Event Type"));
		add(eventTypePanel);
		eventTypePanel.setLayout(new BoxLayout(eventTypePanel, BoxLayout.Y_AXIS));

		//create radio buttons for open/closed events in one button group
		rdbtnClosedEvent = new JRadioButton("Closed Event");
		eventTypeButtonGroup.add(rdbtnClosedEvent);
		eventTypePanel.add(rdbtnClosedEvent);
		rdbtnClosedEvent.setSelected(true);

		rdbtnOpenEvent = new JRadioButton("Open Event");
		eventTypeButtonGroup.add(rdbtnOpenEvent);
		eventTypePanel.add(rdbtnOpenEvent);
		
		JPanel choiceModePanel = new JPanel();
		choiceModePanel.setBounds(166, 113, 129, 76);
		choiceModePanel.setBorder(BorderFactory.createTitledBorder("User Choice Mode"));
		add(choiceModePanel);
		choiceModePanel.setLayout(new BoxLayout(choiceModePanel, BoxLayout.Y_AXIS));

		//create radio buttons for round robin and asynchronous game play
		rdbtnAsynch = new JRadioButton("Asynch");
		gamePlayTypeButtonGroup.add(rdbtnAsynch);
		choiceModePanel.add(rdbtnAsynch);

		rdbtnRoundRobin = new JRadioButton("Round Robin");
		gamePlayTypeButtonGroup.add(rdbtnRoundRobin);
		choiceModePanel.add(rdbtnRoundRobin);
		rdbtnRoundRobin.setSelected(true);

		//set up a box to enter the number of choices available
		JPanel numberOfChoicesPanel = new JPanel();
		numberOfChoicesPanel.setBounds(372, 113, 150, 53);
		numberOfChoicesPanel.setBorder(BorderFactory.createTitledBorder("Number of Choices"));
		add(numberOfChoicesPanel);

		textField_NumberOfChoices = new JTextField();
		numberOfChoicesPanel.add(textField_NumberOfChoices);
		textField_NumberOfChoices.setColumns(10);

		//set up a box to enter the number of rounds to be played
		JPanel numberOfRoundsPanel = new JPanel();
		numberOfRoundsPanel.setBounds(372, 177, 150, 60);
		numberOfRoundsPanel.setBorder(BorderFactory.createTitledBorder("Number of Rounds"));
		add(numberOfRoundsPanel);

		textField_NumberOfRounds = new JTextField();
		numberOfRoundsPanel.add(textField_NumberOfRounds);
		textField_NumberOfRounds.setColumns(10);

		//When this button is clicked, a new event is created
		btnCreateThisEvent = new JButton("Create this event");
		btnCreateThisEvent.setEnabled(true);
		btnCreateThisEvent.setBounds(117, 491, 163, 23);
		btnCreateThisEvent.addActionListener(new CreateNewEventController(model, this));
		add(btnCreateThisEvent);

		//when this button is clicked, the current form exits
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(372, 491, 89, 23);
		btnCancel.addActionListener(new ButtonController(model, 3, this));
		add(btnCancel);
	}
	
	/**
	 * This method is an accessor to determine the event type
	 * @return String eventType
	 */
	public String getEventType() {
		if (rdbtnClosedEvent.isSelected()) {
			return "Closed";
		}
		else {
			return "Open";
		}
	}
	
	/**
	 * This method is an accessor to determine the game play type
	 * @return String gameplayType
	 */
	public String getChoiceMode() {
		if (rdbtnRoundRobin.isSelected()) {
			return "Round Robin";
		}
		else {
			return "Asynchronous";
		}
	}
	
	/**
	 * This method is an accessor for the number of choices in this event
	 * @return int numberOfChoices
	 */
	public int getNumberOfChoices() {
		if(!textField_NumberOfChoices.getText().equals(""))
			return Integer.parseInt(textField_NumberOfChoices.getText());
		else
			return 1;
	}
	
	/**
	 * This method is an accessor for the number of rounds in this event
	 * @return int numberOfRounds
	 */
	public int getNumberOfRounds() {
		if(!textField_NumberOfRounds.getText().equals(""))
			return Integer.parseInt(textField_NumberOfRounds.getText());
		else
			return 1;
	}
	
	/**
	 * This method returns the question specified by the moderator for the event
	 * @return
	 */
	public String getQuestion() {
		return questionTextField.getText();
	}

	/**
	 * Repaint the form
	 */
	public void redraw() {
		this.repaint();
	}
}
