package DLS.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

//====================================================================
//This class provides the GUI elements of the credentials panel
//Rev 1  -M. Peltola   20-Oct-2012 Class created 
//====================================================================	
public class CredentialsPanel  extends JPanel{

	final int left = 1;
	final int top = 5;
	final int width = 577;
	final int height = 60;
	private JTextField textField;
	private JTextField textField_1;
	
	//====================================================================
	//The constructor does the work of setting up the UI elements
	//of the credentials panel 
	//Rev 1  -M. Peltola   20-Oct-2012 Class created 
	//====================================================================
	public CredentialsPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));		
		setBorder(BorderFactory.createTitledBorder("Credentials"));
			setBounds(left,top,610,90);
		setLayout(null);
		
		int y = 22;
		
		textField = new JTextField();
		textField.setBounds(55, y, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(20, y, 46, 14);
		add(lblUser);
		
		JLabel lblPassword = new JLabel("Password(optional)");
		lblPassword.setBounds(162, y, 112, 14);
		add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(276, y, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmitCredentials = new JButton("Submit Credentials");
		btnSubmitCredentials.setBounds(396, y, 145, 23);
		add(btnSubmitCredentials);
		
	}
}