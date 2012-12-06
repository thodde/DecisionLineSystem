package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.CredentialsForm;
import view.EdgeDisplayForm;
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
	Model model;
	CredentialsForm cf;
	EdgeDisplayForm edf;
	boolean moderator;
	
	/**
	 * This constructor sets up the data needed to validate the users credentials with the server
	 * @param m : Model object
	 * @param cf : CredentialsForm object
	 * @param moderator : boolean, true if the user is the moderator
	 */
	public ValidateCredentialsController(CredentialsForm cf, boolean moderator) {
		this.model = Model.getModel();
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
	 * @param isvalid means if the user leaves the user name blank
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Send XML Request to server 
		if (moderator) {
			DecisionLinesEvent dle = model.getDecisionLinesEvent();
			
			String xml = Message.requestHeader() + "<createRequest behavior='"+ dle.getMode()+"' type='"+dle.getType()+"' question='"
					+dle.getQuestion() + "' numChoices='"+dle.getNumChoices()+"' numRounds='"+dle.getRounds()+"'>";
			for (int i = 0; i < dle.choices.size(); i++) {
				xml += "<choice value='" + dle.choices.get(i) + "' index='" + i + "'/>";
			}
			xml += "<user name='"+ cf.getUsername() + "' password='" + new String(cf.getPassword()) + "'/>" +
					"</createRequest>"+"</request>";
			Message m = new Message (xml);
			Access ac = Access.getInstance();
			ac.getAccess().sendRequest(m);
			
			cf.dispose();
			edf = new EdgeDisplayForm();
			edf.setVisible(true);
		}
		else {
			//TODO non moderators need to go to the choice screen
			boolean isValid = credentialsAreValid(cf.getUsername(), cf.getPassword());
			if(isValid)	{
				Model model = Model.getModel();
				String eventId = model.getDecisionLinesEvent().getEventID();
				// convert the char[] to String 
				DecisionLinesEvent event = DecisionLinesEvent.getInstance();
				String s = new String(cf.getPassword());
				event.setUsername(cf.getUsername());
				event.setPassword(s);
				String xmlString = Message.requestHeader() + "<signInRequest id='" + eventId + "'>"+
						"<user name='"+ cf.getUsername() + "' password='" + s + "'/>" +
						"</signInRequest></request>";
				Message m = new Message (xmlString);
				
				// get the ServerAccess, then send the request
				Access ac = Access.getInstance();
				ac.getAccess().sendRequest(m);
			}
			cf.dispose();
			edf = new EdgeDisplayForm();
			edf.setVisible(true);
		}
	}
}

