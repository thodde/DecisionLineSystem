package DLS.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DLS.Controller.UIStateController;

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

	JTextField textField;
	JButton button_1;
	
	//====================================================================
	//The constructor does the work of setting up the UI elements
	//when they start a session with DLS 
	//Rev 1  -M. Peltola   18-Oct-2012 Class created 
	//====================================================================
	public WelcomePanel() {

		setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		setBorder(BorderFactory.createTitledBorder("Welcome to DecisionLines - Please choose your role"));

		setBounds(1,11,507,234);
		setLayout(null);

		JPanel innerWelcomePanel = new JPanel();

		innerWelcomePanel.setLayout(null);

		innerWelcomePanel.setBounds(10, 23, 329,101);
		innerWelcomePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		add(innerWelcomePanel);

		innerWelcomePanel.setLayout(null);


		JButton button = new JButton("Moderator");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				UIStateController usc = UIStateController.getUIStateController();
				usc.updateUIToNextState(UIStateController.AppState.CREATE_EVENT);	
			}
		});
		button.setBounds(20, 11, 142, 23);
		innerWelcomePanel.add(button);

		button_1 = new JButton("User");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				UIStateController usc = UIStateController.getUIStateController();
				usc.updateUIToNextState(UIStateController.AppState.ADD_RR_EDGE);
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		button_1.setBounds(172, 11, 136, 23);
		innerWelcomePanel.add(button_1);

		JLabel lblNewLabel = new JLabel("EventID?");
		lblNewLabel.setBounds(60, 74, 74, 14);
		innerWelcomePanel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Administrator");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				UIStateController usc = UIStateController.getUIStateController();
				usc.updateUIToNextState(UIStateController.AppState.ADMIN);

			}
		});
		btnNewButton.setBounds(357, 96, 136, 28);
		add(btnNewButton);


		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(textField.getText().length()>0)
				{
					button_1.setEnabled(true);
				}
				else
				{
					button_1.setEnabled(false);
				}
			}
		});
		textField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				int y = 22;
			}

		});
		textField.setBounds(144, 71, 130, 20);
		innerWelcomePanel.add(textField);
		textField.setColumns(10);

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
}

