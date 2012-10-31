package DLS.view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import DLS.Controller.View.MoveToEdgeController;
import DLS.Controller.View.NumberListener;
import DLS.Controller.View.QuestionListener;
import DLS.Controller.View.SubmitClosedEventController;
import DLS.Controller.View.SubmitOpenEventController;
import DLS.Controller.View.TextController;
//import DLS.Controller.View.UIStateController;
//import DLS.Controller.View.UIStateController.AppState;
import DLS.model.Model;
import DLS.model.Value;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// no longer compiles delete soon real soon
//====================================================================
//This class provides the GUI elements of the create event panel
//Rev 1  -M. Peltola   20-Oct-2012 Class created 
//====================================================================	
abstract class CreateEvent extends JPanel {
	private JTextField textField;
	private JTextField textField_NumberOfChoices;
	private JTextField textField_NumberOfRounds;
	private JTextField questionTextField;
	private JButton btnCreateThisEvent;
	private JRadioButton rdbtnClosedEvent;
	private JRadioButton rdbtnOpenEvent;
	private JRadioButton rdbtnAsynch;
	private JRadioButton rdbtnRoundRobin;
	private ChoiceListEditor choiceListEditor;
	private AddOpenEventChoice addOpenEventChoice;
	
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

	//====================================================================
	//The constructor does the work of setting up the UI elements
	//of the create Event Panel 
	//Rev 1  -M. Peltola   20-Oct-2012 Class created 
	//====================================================================
	@SuppressWarnings("deprecation")
	public CreateEvent() {
		
//		submitClosedEventController = new SubmitClosedEventController();
//		submitOpenEventController = new SubmitOpenEventController();

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
//		questionTextField.addKeyListener(new QuestionListener(this));
		questionTextField.setForeground(Color.BLACK);

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

		btnCreateThisEvent = createCommonCreateButton();

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(372, 491, 89, 23);
		add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				closeFrame();
			}
		});
	}


	//====================================================================
	// Creates the common (shared by open & closed) create button
	//of the create Event Panel 
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================
	JButton createCommonCreateButton()
	{
		JButton button = new JButton("Create this event");

		/**
		 * Create event button and listener
		 */
		button.setEnabled(false);

		button.setBounds(117, 491, 163, 23);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				// The moderator has chosen to create a closed event
				if (rdbtnClosedEvent.isSelected())
				{
					MainForm mf = MainForm.getMainForm();
					mf.updateStatus(true, "  ");
					
					// remove current button (replaced by phase 2 button)
					remove(btnCreateThisEvent);

					//Disable previous controls
					disableEarlyEventConfigControls();

					addLateCreateEventConfigControls();
					mf.updateStatus(true, "Finish Closed event ");
				}
				
				// else he moderator has chosen to create an open event
				// Submit the event 
				// The moderator is done with the CreateEvent GUI
				else
				{
					submitOpenEvent();
				}
			}
		});

		add(button);
		return button;
	}

	//====================================================================
	// Creates the submit event create button for closed events
	//of the create Event Panel 
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================
	JButton createSubmitClosedEventButton()
	{
		JButton button = new JButton("Create this event");

		/**
		 * Create event button and listener
		 */
		button.setEnabled(true);

		button.setBounds(117, 491, 163, 23);
		
		button.addActionListener(new MoveToEdgeController());

		add(button);
		return button;
	}

	//====================================================================
	// Sets up the add edge GUI
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	private void setupAddEdgeGUI(String eventID, boolean moderator)
	{
		MainForm mf = MainForm.getMainForm();
		
		mf.updateStatus(true, "RR Edge");
		mf.showCredentialsPanel(true);
		
		EdgeDisplayPanel p1 = new EdgeDisplayPanel(Model.getModel(), moderator);
		p1.setVisible(true);
		mf.add(p1);
		mf.setTitle("Decision Lines - Add your edge");		
	}
	
	
	
	//====================================================================
	// add controls used in later portion oef event creation.
	// Only used in closed event creation 
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================
	private void 	addLateCreateEventConfigControls()
	{
		addList();
		btnCreateThisEvent = createSubmitClosedEventButton();
	}

	//====================================================================
	// add list of choices
	// The hard coded version will be replaced by empty list
	// which is filled by moderator of clsoed event.
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================
	private void addList()
	{

		String [] theChoiceList = {
				"Mango",
				"Apple",
				"Grape",
				"Pomegranate"
		};

		choiceListEditor = new ChoiceListEditor("Choices", theChoiceList, true,false); 
		choiceListEditor.setBounds(45, 250, 450, 235);
		add(choiceListEditor);

		repaint();
	}

	//====================================================================
	// submit open event to server for acceptance
	//of the create Event Panel 
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================
	private void submitOpenEvent()
	{			
		String eventID = submitOpenEventController.submit(questionTextField.getText(), 
				rdbtnRoundRobin.isSelected(),
				numberOfChoicesListener.getCurrentValue(),
				numberOfRoundsListener.getCurrentValue());
		
		if (eventID.length()>0)
		{
			removeCreateEventPanel();
			MainForm mf = MainForm.getMainForm();
			mf.updateStatus(true, "Open event submitted");
			String question = "Why?";
			String [] existingChoices = {"Choice1", 
					"Choice2"};
			
			AddOpenEventChoice addOpenEventChoice = new AddOpenEventChoice(eventID, questionTextField.getText(), existingChoices);
			addOpenEventChoice.setBounds(1,40,450,430);
			
			mf.add(addOpenEventChoice);
			mf.repaint();

		}
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
		textField_NumberOfRounds.setEnabled(false);
	}

	//====================================================================
	// remove crqte vent panel from main form
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	private void removeCreateEventPanel(){
		MainForm mf = MainForm.getMainForm();
		mf.remove(this);
		mf.repaint();
	}

	/**
	 * Make sure the user can exit the form if they choose to do so
	 */
	public void closeFrame() {
		JFrame frame = (JFrame) this.getTopLevelAncestor();
		frame.dispose();
	}

	public void setValidQuestion(boolean b)
	{
		validQuestion = b;
		updateCreateEventButtonStatus();
	}

	public void SetValidNumberOfRounds(boolean b)
	{
		validNumOfRounds = b;
	}

	public void SetValidNumberOfChoices(boolean b)
	{
		validNumOfChoices = b;
	}

	public void updateCreateEventButtonStatus(){

		btnCreateThisEvent.setEnabled(validQuestion);
	}	
}
