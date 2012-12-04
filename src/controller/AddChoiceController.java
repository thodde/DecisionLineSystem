package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

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
		System.out.println("" + event.getType());
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("" + event.getType());
		
		// This is in open event
		if(event.getType().equalsIgnoreCase("open")){
			String choice = cle.currentItem;
			//send the request of adding choice
			String postion = String.valueOf(event.getPostion());
			String xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
					" number='"+postion+ "' choice='" + choice + "'/>" +"</request>";	
			Message m = new Message (xml);
			Access ac = Access.getInstance();
			ac.getAccess().sendRequest(m);
			
			cle.dispose();
			cf = new CredentialsForm(Model.getModel(), false);
		}
		else if(event.getType().equalsIgnoreCase("closed")) { // This is in the closed event, only moderator can add all the choice
			 for (Iterator<String> itr = cle.currentList.iterator(); itr.hasNext();) {
				 int i = 0;
				 String choice = itr.next();
				 event.setChoice(i, choice);
				 i++;
				 String xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
							" number='" + i +  "' choice='" + choice + "'/>" +"</request>";	
				 Message m = new Message (xml);
				 Access ac = Access.getInstance();
				 ac.getAccess().sendRequest(m);
			 }
			 cle.dispose();
			 cf = new CredentialsForm(Model.getModel(), false);
		}
	}
}