package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.CredentialsForm;
import view.EdgeDisplayForm;
import xml.Message;
import client.*;
import model.Access;
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
	
	/**
	 * This constructor sets up the data needed to validate the users credentials with the server
	 * @param m : Model object
	 * @param cf : CredentialsForm object
	 * @param moderator : boolean, true if the user is the moderator
	 */
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
		
		//makes sure the user enters a valid username
		if(user == null || user.equals("")) {
			JOptionPane.showMessageDialog(null, "You must enter a username!");
			stat = false;
		}
		else {
			stat = true;
		}
		return stat;
	}
	
	/**
	 * This method can send the SignInRequest to the server
	 * @author Hang, Wei
	 * @param isvalid means if the user only type"" or leave the username blank
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Send XML Request to server 
		boolean isValid = credentialsAreValid(cf.getUsername(), cf.getPassword());
		if(isValid)	{
			Model model = Model.getModel();
			String eventId = model.getDecisionLinesEvent().getEventID();
			// convert the char[] to String 
			String s =new String(cf.getPassword());
			String xmlString = Message.requestHeader() + "<signInRequest id='"+eventId +"'>"+
					"<user name='"+ cf.getUsername() + "' password='" + s + "'/>" +
					"</signInRequest>"+"</request>";
			Message m = new Message (xmlString);
			
			// get the ServerAccess, then send the request
			Access ac = Access.getInstance();
			ac.getAccess().sendRequest(m);
		}
		cf.dispose();
	}
}

