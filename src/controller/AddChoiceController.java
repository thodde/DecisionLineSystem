package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import model.Access;
import model.DecisionLinesEvent;
import view.ChoiceListEditor;
import xml.Message;

/**
 * This class is used for sending the addChoiceRequest to the server
 * @author Hang, Wei
 *
 */
public class AddChoiceController implements ActionListener{
	ChoiceListEditor cle;
	DecisionLinesEvent event;
	public AddChoiceController (ChoiceListEditor cle, DecisionLinesEvent event) {
		this.cle = cle;
		this.event = event;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		// This is in open event
		if(event.getType() == "open"){
			String choice = cle.currentItem;
			//send the request of adding choice
			String postion = String.valueOf(event.getPostion());
			String xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
					" number='"+postion+ "' choice='" + choice + "'/>" +"</request>";	
			Message m = new Message (xml);
			Access ac = Access.getInstance();
			ac.getAccess().sendRequest(m);
		}
		// This is in the closed event, only moderatot can add all the choice
		if(event.getType() == "closed"){
			 for (Iterator<String> itr = cle.currentList.iterator(); itr.hasNext();) {
				 int i = 0;
				 String choice = itr.next();
				 event.setChoice(i, choice);
				 i++;
				 String xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
							" number='"+i+ "' choice='" + choice + "'/>" +"</request>";	
				 Message m = new Message (xml);
				 Access ac = Access.getInstance();
				 ac.getAccess().sendRequest(m);
			 }
			 
		}
	}
}

