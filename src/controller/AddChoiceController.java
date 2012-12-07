package controller;

import java.awt.List;
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
	CredentialsForm cf;
	
	public AddChoiceController(ChoiceListEditor cle) {
		this.cle = cle;
	}

	public void actionPerformed(ActionEvent arg0) {
		DecisionLinesEvent event = Model.getModel().getDecisionLinesEvent();
		List choiceList = cle.getChoices();
		
		String xml;
		for (int i = 0; i < choiceList.getRows(); i++) {
			if (event.position == 0) // is moderator
				xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
						" number='" + i + "' choice='" + choiceList.getItem(i) + "'/></request>";				
			else
				xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
						" number='" + i + "' choice='" + choiceList.getItem(i) + "'/></request>";				

			Message m = new Message (xml);
			Access ac = Access.getInstance();
			ac.getAccess().sendRequest(m);
		}
		cle.dispose();
		
		/*
		// This is in open event
		if(event.getType().equalsIgnoreCase("open")){
			String choice = cle.event.choices.size() + "";
			//send the request of adding choice
			String postion = String.valueOf(event.getPostion());
			String xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
					" number='" + postion + "' choice='" + choice + "'/></request>";	
			Message m = new Message (xml);
			Access ac = Access.getInstance();
			ac.getAccess().sendRequest(m);
			
			cf = new CredentialsForm(false);
			cf.setVisible(true);
			cle.dispose();
		}
		else { // This is in the closed event, only moderator can add all the choices
			for (int i = 0; i < cle.event.choices.size(); i++) {
				 String choice = cle.event.choices.get(i);
				 event.setChoice(i, choice);
				 String xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
							" number='" + i +  "' choice='" + choice + "'/></request>";	
				 Message m = new Message (xml);
				 Access ac = Access.getInstance();
				 ac.getAccess().sendRequest(m);
			}
			cf = new CredentialsForm(false);
			cf.setVisible(true);
			cle.dispose();
		}
		*/
	}
}