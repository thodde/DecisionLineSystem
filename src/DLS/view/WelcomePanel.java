package DLS.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DLS.Controller.View.CreateNewEventController;
import DLS.Controller.View.ExistingEventController;
import DLS.Controller.View.UserAddOpenChoiceController;
//import DLS.Controller.View.UIStateController;
import DLS.Controller.View.ValidateEventIDController;
import DLS.Controller.View.WelcomeAdministratorController;
import DLS.Controller.View.UserAddEdgeController;
import DLS.model.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


//====================================================================
//This class provides the initial GUI elements which greet a user
//when they start a session with DLS 
//Rev 1  -M. Peltola   18-Oct-2012 Class created 
//====================================================================
public class WelcomePanel extends JPanel{

	JTextField textEventIDField;
	JButton button_User;

	private static  WelcomePanel wpInstance;

	public static WelcomePanel GetWelcomePanel()
	{
		if (wpInstance == null)
		{
			wpInstance = new WelcomePanel();
		}
		return wpInstance;
	}

	WelcomeAdministratorController welcomeAdminController;
	UserAddEdgeController userAddEdgeController;
	UserAddOpenChoiceController userAddOpenChoiceController;
	CreateNewEventController createNewEventController;
	ExistingEventController existingEventController;	
	ValidateEventIDController validateEventIDController;
	
	//====================================================================
	//The constructor does the work of setting up the UI elements
	//when they start a session with DLS 
	//Rev 1  -M. Peltola   18-Oct-2012 Class created 
	//====================================================================
	private WelcomePanel() {

		createControllers();

		setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		setBorder(BorderFactory.createTitledBorder("Welcome to DecisionLines - Please choose your role"));

		setBounds(1,11,507,234);
		setLayout(null);

		JPanel innerWelcomePanel = createInnerPanel();
		createModeratorButton(innerWelcomePanel);
		button_User = createUserButton(innerWelcomePanel);

		JLabel lblNewLabel = new JLabel("EventID?");
		lblNewLabel.setBounds(60, 74, 74, 14);
		innerWelcomePanel.add(lblNewLabel);

		// START ADMINISTRATOR BUTTON CODE
		createAdminButton();

		// sets up class reference, so nothing returned
		createEventIDCluster(innerWelcomePanel);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(229, 184, 89, 23);
		add(btnExit);

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				closeForm();
			}
		});
	}

	public void closeForm() {
		JFrame frame = (JFrame) this.getTopLevelAncestor();
		frame.dispose();
	}

	//====================================================================
	//The method creates the welcome panel's inner panel
	//Rev 1  -M. Peltola   18-Oct-2012 Class created 
	//====================================================================	
	private JPanel createInnerPanel()
	{
		JPanel innerWelcomePanel = new JPanel();
		innerWelcomePanel.setLayout(null);
		innerWelcomePanel.setBounds(10, 23, 329,101);
		innerWelcomePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		add(innerWelcomePanel);
		innerWelcomePanel.setLayout(null);
		return innerWelcomePanel;
	}		

	//====================================================================
	//The method creates the moderator button
	//Rev 1  -M. Peltola   18-Oct-2012 Class created 
	//====================================================================	
	JButton createModeratorButton(JPanel innerPanel)
	{
		// START MODERATOR BUTTON CODE
		JButton button = new JButton("Moderator");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				String eventID = textEventIDField.getText();

				if (eventID.length()== 0)
				{
					createNewEventController.setupAddNewEventGUI();
					removeWelcomePanel();
					setVisible(false);				}
				else
				{
					if (validateEventIDController.isValidEventID(eventID))
					{
						existingEventController.setupExistingEventGUI(eventID);
						removeWelcomePanel();
						setVisible(false);						
					}
				}
			}
		});

		button.setBounds(20, 11, 142, 23);
		innerPanel.add(button);

		return button;
	}

	//====================================================================
	//The method creates the user button
	//Rev 1  -M. Peltola   18-Oct-2012 Class created 
	//====================================================================	
	JButton createUserButton(JPanel innerPanel)
	{
		// START USER BUTTON CODE
		JButton button = new JButton("User");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			
				String eventID = textEventIDField.getText();

				if (validateEventIDController.isValidEventID(eventID))
				{
					Model m = Model.getModel();

					if(m.isClosedEventType(eventID))
					{
						userAddEdgeController.setupAddEdgeGUI(eventID, false);
						removeWelcomePanel();
					
					}
					else
					{
						userAddOpenChoiceController.setupAddChoiceGUI(eventID, false);
						removeWelcomePanel();
					}
				}
			}
		});
		
		button.setBounds(172, 11, 136, 23);
		innerPanel.add(button);
		return button;
	}

	//====================================================================
	//The method creates the admin button
	//Rev 1  -M. Peltola   18-Oct-2012 Class created 
	//====================================================================	
	JButton createAdminButton()
	{
		JButton btnAdministrator = new JButton("Administrator");

		btnAdministrator.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

				//UIStateController usc = UIStateController.getUIStateController();
				//usc.updateUIToNextState(UIStateController.AppState.ADMIN);
				welcomeAdminController.setupAdminGUI();

				removeWelcomePanel();
			}
		});
		
		btnAdministrator.setBounds(357, 96, 136, 28);
		add(btnAdministrator);
		return btnAdministrator;
	}

	//====================================================================
	//The method creates the eventID cluster (label and txt control)
	//Rev 1  -M. Peltola   18-Oct-2012 Class created 
	//====================================================================	
	private void createEventIDCluster(JPanel innerPanel)
	{
		// START EVENT ID CODE
		textEventIDField = new JTextField();
		textEventIDField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(textEventIDField.getText().length()>0)
				{
					button_User.setEnabled(true);
				}
				else
				{
					button_User.setEnabled(false);
				}
			}
		});

		textEventIDField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				int y = 22;
			}

		});
		textEventIDField.setBounds(144, 71, 130, 20);
		innerPanel.add(textEventIDField);
		textEventIDField.setColumns(10);
	}


	//====================================================================
	//The method creates the welcome panel's UI controllers
	//Rev 1  -M. Peltola   25-Oct-2012 Class created 
	//====================================================================	
	private void createControllers()
	{
		welcomeAdminController = new WelcomeAdministratorController() ;
		userAddEdgeController = new UserAddEdgeController();
		userAddOpenChoiceController = new UserAddOpenChoiceController();
			createNewEventController = new CreateNewEventController ();
		existingEventController = new ExistingEventController();
		validateEventIDController = new ValidateEventIDController();
	}

	//====================================================================
	//The method removes the welcome panel from the main form
	//Rev 1  -M. Peltola   25-Oct-2012 Class created 
	//====================================================================	
	private void removeWelcomePanel()
	{
		WelcomePanel wp =  WelcomePanel.GetWelcomePanel();

		MainForm mf = MainForm.getMainForm();
		mf.remove(wp);
		
		
		mf.invalidate();
		mf.pack();
		mf.setSize(800,800);  // need to be bigger
		
		mf.repaint();  // redundant
	}
	
	
	
}

