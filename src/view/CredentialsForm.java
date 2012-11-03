package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import model.Model;
import controller.ValidateCredentialsController;

/**
 * This class accepts the users credentials and send them to the controller
 * to validate them with the server
 * @author Trevor Hodde
 */
public class CredentialsForm extends JFrame {

	private static final long serialVersionUID = 1L;
	final int left = 1;
	final int top = 5;
	final int width = 577;
	final int height = 60;
	JTextField txtUsername;
	JTextField txtPassword;
	JPanel contentPane;
	Model model;
	boolean moderator;
	
	public CredentialsForm(Model m, boolean moderator)
	{
		this.model = m;
		this.moderator = moderator;
		setTitle("Draw2Choose Sign-In");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(575, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(55, 22, 86, 20);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(20, 22, 46, 14);
		add(lblUser);
		
		JLabel lblPassword = new JLabel("Password(optional)");
		lblPassword.setBounds(162, 22, 112, 14);
		add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(276, 22, 86, 20);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnSubmitCredentials = new JButton("Submit Credentials");
		btnSubmitCredentials.setBounds(396, 22, 145, 23);
		add(btnSubmitCredentials);
		
		btnSubmitCredentials.addActionListener(new ValidateCredentialsController(model, this, moderator));
	}
	
	/**
	 * @return String: the username of the user
	 */
	public String getUsername() {
		return txtUsername.getText();
	}
	
	/**
	 * @return String: the password of the user
	 */
	public String getPassword() {
		return txtPassword.getText();
	}
}