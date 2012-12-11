package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.CredentialsForm;
import xml.Message;
import model.Access;
import model.DecisionLinesEvent;
import model.Model;

/**
 * This class sends an XML request to the server to 
 * validate the users credentials.
 * @author Trevor Hodde
 */
public class ValidateCredentialsController implements ActionListener {
	CredentialsForm cf;
	String xmlString;
	Model model;

	/**
	 * This constructor sets up the data needed to validate the users credentials with the server
	 * @param m : Model object
	 * @param cf : CredentialsForm object
	 * @param moderator : boolean, true if the user is the moderator
	 */
	public ValidateCredentialsController(CredentialsForm cf) {
		this.cf = cf;
		xmlString = "";
		model = Model.getModel();
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
	 * @param isvalid means if the user leaves the user name blank
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if(GenerateRequest(cf.getUsername(), cf.getPassword(), cf.isNewEvent, cf.question, cf.eventType, cf.choiceMode, cf.numChoices, cf.numRounds, cf.eventId)){
			
			Message m = new Message (xmlString);
			Access ac = Access.getInstance();
			ac.getAccess().sendRequest(m);
			
			cf.dispose();
		}

	}

	public String GetGeneratedRequest()
	{
		return xmlString;
	}
	
	public boolean GenerateRequest(String username, char[] password, boolean isNewEvent, String question, String eventType, String choiceMode, int numChoices, int numRounds, String eventId)
	{
        boolean stat = false;
		boolean isValid = credentialsAreValid(username, password);
		if(isValid) {
			//Send XML Request to server 
			if (isNewEvent) { //CreateRequest
				
				xmlString = Message.requestHeader() + "<createRequest behavior='"+ choiceMode + "' type='" + eventType + "' question='"
						+ question + "' numChoices='" + numChoices + "' numRounds='" + numRounds + "'>" +
						"<user name='"+ username + "' password='" + new String(password) + "'/>" +
						"</createRequest>"+"</request>";

				stat = true;
			}
			else { //signInRequest
	
				String s = new String(password);
				xmlString = Message.requestHeader() + "<signInRequest id='" + eventId + "'>"+
						"<user name='"+ username + "' password='" + s + "'/>" +
						"</signInRequest></request>";
				stat = true;


			}
			
			//store the user name and password on the model 
			//so the moderator can be signed in directly later
			model.setUsername(username);
			model.setPassword(new String(password));
		}
		return stat;

	}
}

