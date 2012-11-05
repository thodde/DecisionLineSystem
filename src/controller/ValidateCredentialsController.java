package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.CredentialsForm;
import view.EdgeDisplayForm;

import model.Model;

/**
 * This class sends an XML request to the server to 
 * validate the users credentials.
 * @author Trevor Hodde
 */
public class ValidateCredentialsController implements ActionListener {
	Model model;
	CredentialsForm cf;
	boolean moderator;
	
	public ValidateCredentialsController(Model m, CredentialsForm cf, boolean moderator) {
		this.model = m;
		this.cf = cf;
		this.moderator = moderator;
	}
	
	/**
	 * Validates with the server that the credentials of the user are valid
	 * @param user : String username
	 * @param password : char[] the users password
	 * @return boolean : determines if the credentials were accepted by the server
	 */
	public boolean credentialsAreValid(String user, char[] password) {
		boolean stat;
		
		if(user == null || user.equals("")) {
			JOptionPane.showMessageDialog(null, "You must enter a username!");
			stat = false;
		}
		else {
			stat = true;
		}
		return stat;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Send XML Request to server to validate user
		boolean isValid = credentialsAreValid(cf.getUsername(), cf.getPassword());
		
		//if the credentials are valid, close the form
		if(isValid) {
			cf.dispose();
			
			EdgeDisplayForm edf = new EdgeDisplayForm(model, moderator);
			edf.setVisible(true);
			System.out.println("Moderator: " + moderator);
		}
	}
}
