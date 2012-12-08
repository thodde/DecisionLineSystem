package controller;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Access;
import model.DecisionLinesEvent;
import model.Model;
import view.ChoiceListEditor;
import xml.Message;

/**
 * This class allows the user to add choices to an event and
 * send the choices to the server
 * @author Trevor Hodde
 */
public class AddChoiceController implements ActionListener{
	ChoiceListEditor cle;
	
	/**
	 * This constructor take a reference to the choice list editor
	 * so it can be closed later
	 * @param cle ChoiceListEditor
	 */
	public AddChoiceController(ChoiceListEditor cle) {
		this.cle = cle;
	}

	/**
	 * This method sends an XML request to the server with choices from the list editor
	 */
	public void actionPerformed(ActionEvent arg0) {
		DecisionLinesEvent event = Model.getModel().getDecisionLinesEvent();
		List choiceList = cle.getChoices();
		
		String xml;
		for (int i = 0; i < choiceList.getItemCount(); i++) {
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
	}
}