package DLS.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DLS.Controller.View.NumberListener;
import DLS.Controller.View.QuestionListener;
import DLS.Controller.View.SubmitClosedEventController;
import DLS.Controller.View.SubmitOpenEventController;
import DLS.model.Model;

public class CreateAddSingleChoiceFrame extends JFrame{
	
	private JTextField textField;
	private JTextField textField_NumberOfChoices;
	private JTextField textField_NumberOfRounds;
	private JTextField questionTextField;
	private JButton btnSubmitChoice;
	private JRadioButton rdbtnClosedEvent;
	private JRadioButton rdbtnOpenEvent;
	private JRadioButton rdbtnAsynch;
	private JRadioButton rdbtnRoundRobin;
	private ChoiceListEditor choiceListEditor;
	//private AddOpenEventChoice addOpenEventChoice;
	
	private NumberListener numberOfChoicesListener;
	private NumberListener numberOfRoundsListener;

	private final ButtonGroup eventTypeButtonGroup = new ButtonGroup();
	private final ButtonGroup gamePlayTypeButtonGroup = new ButtonGroup();
	
	SubmitClosedEventController submitClosedEventController;
	SubmitOpenEventController submitOpenEventController;

	JPanel questionPanel;

	boolean validQuestion;
	boolean validNumOfChoices;
	boolean validNumOfRounds;
	final int maxChoice = 10;	
	final int maxRounds = 8;	


	public CreateAddSingleChoiceFrame(String EventID, String question, String [] existingChoices){
		
	super("Single Choice Frame Frame");

	submitClosedEventController = new SubmitClosedEventController();
	submitOpenEventController = new SubmitOpenEventController();

	validQuestion = false;
	validNumOfChoices = false;
	validNumOfRounds = false;

	setBounds(25,60,550,555);
	setLayout(null);

	questionPanel = new JPanel();
	questionPanel.setBounds(1, 8, 609, 93);
	questionPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));
	questionPanel.setBorder(BorderFactory.createTitledBorder("Event Question"));
	add(questionPanel);

	questionPanel.setLayout(new BorderLayout(0, 0));

	questionTextField = new JTextField();
	questionTextField.setForeground(Color.BLACK);
	questionTextField.setText(question);
	

	questionPanel.add(questionTextField, BorderLayout.CENTER);
	questionTextField.setColumns(10);

	JPanel eventTypePanel = new JPanel();
	eventTypePanel.setBounds(11, 114, 129, 76);
	eventTypePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
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
	choiceModePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
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
	numberOfChoicesPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	numberOfChoicesPanel.setBorder(BorderFactory.createTitledBorder("Number of Choices"));
	add(numberOfChoicesPanel);

	textField_NumberOfChoices = new JTextField();
	numberOfChoicesListener = new NumberListener(2, maxChoice, 2);

	textField_NumberOfChoices.addKeyListener(numberOfChoicesListener);
	textField_NumberOfChoices.setText("" + numberOfChoicesListener.getCurrentValue());

	numberOfChoicesPanel.add(textField_NumberOfChoices);
	textField_NumberOfChoices.setColumns(10);

	JPanel numberOfRoundsPanel = new JPanel();
	numberOfRoundsPanel.setBounds(372, 177, 150, 60);
	numberOfRoundsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	numberOfRoundsPanel.setBorder(BorderFactory.createTitledBorder("Number of Rounds"));
	add(numberOfRoundsPanel);

	textField_NumberOfRounds = new JTextField();
	numberOfRoundsListener = new NumberListener(1, maxRounds, 1);

	textField_NumberOfRounds.addKeyListener(numberOfRoundsListener);
	textField_NumberOfRounds.setText("" + numberOfRoundsListener.getCurrentValue());

	numberOfRoundsPanel.add(textField_NumberOfRounds);
	textField_NumberOfRounds.setColumns(10);


	JLabel lblReady = new JLabel("Ready?");
	lblReady.setBounds(45, 485, 78, 35);
	add(lblReady);

	btnSubmitChoice = createSubmitChoiceButton();
	
	add(btnSubmitChoice);
	
	JPanel choicesPanel = new JPanel();
	choicesPanel.setBounds(40, 240, 350, 230);
	
	choicesPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	choicesPanel.setBorder(BorderFactory.createTitledBorder("Existing Choices"));
	add(choicesPanel);
	
	JList itemList = new JList(existingChoices);
    itemList.setSize(200,140);
    itemList.setVisibleRowCount(4);
    choicesPanel.add(itemList);
    
    
    JLabel lblYourChoice= new JLabel("Your Choice?");
    lblYourChoice.setBounds(5, 420, 78, 35);
    choicesPanel.add(lblYourChoice);
	
	JTextField yourChoice = new JTextField();
	yourChoice.setBounds(120, 420, 78, 35);
	yourChoice.setColumns(20);
	choicesPanel.add(yourChoice);
	
	
	JButton btnCancel = new JButton("Cancel");
	btnCancel.setBounds(372, 491, 89, 23);
	add(btnCancel);

	btnCancel.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		}
	});
	
	disableEarlyEventConfigControls();
	
	}
	
	
	//====================================================================
	// disable the early controls (allow changes only for initial event creation)
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================
	private void disableEarlyEventConfigControls()
	{
		questionTextField.setEnabled(false);
		questionTextField.setForeground(Color.BLACK);

		rdbtnClosedEvent.setEnabled(false);
		rdbtnOpenEvent.setEnabled(false);

		rdbtnAsynch.setEnabled(false);
		rdbtnRoundRobin.setEnabled(false);

		textField_NumberOfRounds.setEnabled(false);
		textField_NumberOfChoices.setEnabled(false);
	}
		
private JButton createSubmitChoiceButton()
{
	JButton button = new JButton("Submit Choice");

	/**
	 * Create event button and listener
	 */
	button.setEnabled(true);

	button.setBounds(117, 491, 163, 23);

	button.setBounds(117, 491, 163, 23);
	button.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent arg0) {
			setVisible(false);
			Model m = Model.getModel();
			EdgeDisplayFrame p = new EdgeDisplayFrame(m, true);
			p.setVisible(true);
		}

	}
	);
	
	add(button);
	return button;
}
	
	
}
