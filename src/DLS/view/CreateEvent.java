package DLS.view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

//====================================================================
//This class provides the GUI elements of the create event panel
//Rev 1  -M. Peltola   20-Oct-2012 Class created 
//====================================================================	
public class CreateEvent extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup eventTypeButtonGroup = new ButtonGroup();
	private final ButtonGroup gamePlayTypeButtonGroup = new ButtonGroup();
	
	//====================================================================
	//The constructor does the work of setting up the UI elements
	//of the creaet Event Panel 
	//Rev 1  -M. Peltola   20-Oct-2012 Class created 
	//====================================================================
	public CreateEvent() {
		setBounds(25,60,550,555);
		setLayout(null);
		
		JPanel questionPanel = new JPanel();
		questionPanel.setBounds(1, 1, 609, 101);
		questionPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));
		questionPanel.setBorder(BorderFactory.createTitledBorder("Event Question"));
		add(questionPanel);
		
		questionPanel.setLayout(new BorderLayout(0, 0));
		
		JTextField questionTextField = new JTextField();
		questionPanel.add(questionTextField, BorderLayout.CENTER);
		questionTextField.setColumns(10);
		
		JPanel eventTypePanel = new JPanel();
		eventTypePanel.setBounds(11, 114, 129, 76);
		eventTypePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		eventTypePanel.setBorder(BorderFactory.createTitledBorder("Event Type"));
		add(eventTypePanel);
		eventTypePanel.setLayout(new BoxLayout(eventTypePanel, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnClosedEvent = new JRadioButton("Closed Event");
		eventTypeButtonGroup.add(rdbtnClosedEvent);
		eventTypePanel.add(rdbtnClosedEvent);
		
		JRadioButton rdbtnOpenEvent = new JRadioButton("Open Event");
		eventTypeButtonGroup.add(rdbtnOpenEvent);
		eventTypePanel.add(rdbtnOpenEvent);
		
		JPanel choiceModePanel = new JPanel();
		choiceModePanel.setBounds(166, 113, 129, 76);
		choiceModePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		choiceModePanel.setBorder(BorderFactory.createTitledBorder("User Choice Mode"));
		add(choiceModePanel);
		choiceModePanel.setLayout(new BoxLayout(choiceModePanel, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnAsynch = new JRadioButton("Asynch");
		gamePlayTypeButtonGroup.add(rdbtnAsynch);
		choiceModePanel.add(rdbtnAsynch);
		
		JRadioButton rdbtnRoundRobin = new JRadioButton("Round Robin");
		gamePlayTypeButtonGroup.add(rdbtnRoundRobin);
		choiceModePanel.add(rdbtnRoundRobin);
		
		JPanel numberOfChoicesPanel = new JPanel();
		numberOfChoicesPanel.setBounds(372, 113, 150, 53);
		numberOfChoicesPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		numberOfChoicesPanel.setBorder(BorderFactory.createTitledBorder("Number of Choices"));
		add(numberOfChoicesPanel);
		
		textField_1 = new JTextField();
		numberOfChoicesPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel numberOfRoundsPanel = new JPanel();
		numberOfRoundsPanel.setBounds(372, 177, 150, 60);
		numberOfRoundsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		numberOfRoundsPanel.setBorder(BorderFactory.createTitledBorder("Number of Rounds"));
		add(numberOfRoundsPanel);
		
		textField_2 = new JTextField();
		numberOfRoundsPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblReady = new JLabel("Ready?");
		lblReady.setBounds(45, 485, 78, 35);
		add(lblReady);
		
		JButton btnCreateThisEvent = new JButton("Create this event");
		btnCreateThisEvent.setBounds(117, 491, 163, 23);
		add(btnCreateThisEvent);
		
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
	
	/**
	 * Make sure the user can exit the form if they choose to do so
	 */
	public void closeFrame() {
		JFrame frame = (JFrame) this.getTopLevelAncestor();
		frame.dispose();
	}
}
