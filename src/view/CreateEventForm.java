package view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JTextField;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.border.EmptyBorder;

import controller.ButtonController;
import controller.CreateNewEventController;
import controller.MoveToEdgeController;
import controller.SubmitClosedEventController;
import controller.SubmitOpenEventController;

import model.Model;

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
		setTitle("Create a Decision Lines Event");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(630, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		questionPanel = new JPanel();
		questionPanel.setBounds(1, 8, 609, 93);
		questionPanel.setBorder(BorderFactory.createTitledBorder("Event Question"));
		add(questionPanel);

		questionPanel.setLayout(new BorderLayout(0, 0));

		questionTextField = new JTextField();
		questionTextField.setForeground(Color.BLACK);

		questionPanel.add(questionTextField, BorderLayout.CENTER);
		questionTextField.setColumns(10);
		
		eventTypeButtonGroup = new ButtonGroup();
		gamePlayTypeButtonGroup = new ButtonGroup();

		JPanel eventTypePanel = new JPanel();
		eventTypePanel.setBounds(11, 114, 129, 76);
		eventTypePanel.setBorder(BorderFactory.createTitledBorder("Event Type"));
		add(eventTypePanel);
		eventTypePanel.setLayout(new BoxLayout(eventTypePanel, BoxLayout.Y_AXIS));

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

		rdbtnAsynch = new JRadioButton("Asynch");
		gamePlayTypeButtonGroup.add(rdbtnAsynch);
		choiceModePanel.add(rdbtnAsynch);

		rdbtnRoundRobin = new JRadioButton("Round Robin");
		gamePlayTypeButtonGroup.add(rdbtnRoundRobin);
		choiceModePanel.add(rdbtnRoundRobin);
		rdbtnRoundRobin.setSelected(true);

		JPanel numberOfChoicesPanel = new JPanel();
		numberOfChoicesPanel.setBounds(372, 113, 150, 53);
		numberOfChoicesPanel.setBorder(BorderFactory.createTitledBorder("Number of Choices"));
		add(numberOfChoicesPanel);

		textField_NumberOfChoices = new JTextField();
		numberOfChoicesPanel.add(textField_NumberOfChoices);
		textField_NumberOfChoices.setColumns(10);

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
	
	public String getEventType() {
		if (rdbtnClosedEvent.isSelected()) {
			return "Closed";
		}
		else {
			return "Open";
		}
	}
	
	public String getChoiceMode() {
		if (rdbtnRoundRobin.isSelected()) {
			return "Round Robin";
		}
		else {
			return "Asynchronous";
		}
	}
	
	public int getNumberOfChoices() {
		if(!textField_NumberOfChoices.getText().equals(""))
			return Integer.parseInt(textField_NumberOfChoices.getText());
		else
			return 1;
	}
	
	public int getNumberOfRounds() {
		if(!textField_NumberOfRounds.getText().equals(""))
			return Integer.parseInt(textField_NumberOfRounds.getText());
		else
			return 1;
	}
	
	public String getQuestion() {
		return questionTextField.getText();
	}

	//====================================================================
	// Creates the submit event create button for closed events
	//of the create Event Panel 
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================
	JButton createSubmitClosedEventButton() {
		JButton button = new JButton("Create this event");
		button.setEnabled(true);
		button.setBounds(117, 491, 163, 23);
		button.addActionListener(new MoveToEdgeController());
		add(button);
		return button;
	}

	private void addLateCreateEventConfigControls() {
		addList();
		btnCreateThisEvent = createSubmitClosedEventButton();
	}

	//====================================================================
	// add list of choices
	// The hard coded version will be replaced by empty list
	// which is filled by moderator of clsoed event.
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================
	private void addList() {
		Vector<String> theChoiceList = new Vector<String>();
		theChoiceList.add("Mango");
		theChoiceList.add("Apple");
		theChoiceList.add("Grape");
		theChoiceList.add("Pomegranate");

		choiceListEditor = new ChoiceListEditor("Choices", theChoiceList, false, model); 
		choiceListEditor.setBounds(45, 250, 450, 235);
		add(choiceListEditor);

		repaint();
	}
	
	public void redraw() {
		this.repaint();
	}
}
