package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Access;
import model.DecisionLinesEvent;
import model.Model;
import view.ChoiceListEditor;
import view.CredentialsForm;
import xml.Message;

/**
 * This class is used for sending the addChoiceRequest to the server
 * @author Hang, Wei
 */
public class AddChoiceController implements ActionListener{
	ChoiceListEditor cle;
	DecisionLinesEvent event;
	CredentialsForm cf;
	
	public AddChoiceController(ChoiceListEditor cle) {
		this.cle = cle;
		this.event = DecisionLinesEvent.getInstance();
	}

	public void actionPerformed(ActionEvent arg0) {
		// This is in open event
		if(event.getType().equalsIgnoreCase("open")){
			String choice = cle.currentList.size() + "";
			//send the request of adding choice
			String postion = String.valueOf(event.getPostion());
			String xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
					" number='" + postion + "' choice='" + choice + "'/></request>";	
			Message m = new Message (xml);
			Access ac = Access.getInstance();
			ac.getAccess().sendRequest(m);
			
			cf = new CredentialsForm(Model.getModel(), false);
			cf.setVisible(true);
			cle.dispose();
		}
		else { // This is in the closed event, only moderator can add all the choices
			for (int i = 0; i < cle.currentList.size(); i++) {
				 String choice = cle.currentList.get(i);
				 event.setChoice(i, choice);
				 String xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
							" number='" + i +  "' choice='" + choice + "'/></request>";	
				 Message m = new Message (xml);
				 Access ac = Access.getInstance();
				 ac.getAccess().sendRequest(m);
			}
			cf = new CredentialsForm(Model.getModel(), false);
			cf.setVisible(true);
			cle.dispose();
		}
	}
}