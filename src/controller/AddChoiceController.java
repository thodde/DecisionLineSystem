package controller;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	public ArrayList<String> xmlStrings;
	DecisionLinesEvent event;
	
	/**
	 * This constructor take a reference to the choice list editor
	 * so it can be closed later
	 * @param cle ChoiceListEditor
	 */
	public AddChoiceController(ChoiceListEditor cle) {
		this.cle = cle;
		event = Model.getModel().getDecisionLinesEvent();
	}

	/**
	 * This method sends an XML request to the server with choices from the list editor
	 */
	public void actionPerformed(ActionEvent arg0) {

		for (int i = 0; i < cle.getChoices().getItemCount(); i++) {
			Message m = new Message (GenerateXML(i));

			// we pass in a null for arg0 from JUnit, as signal not to run these lines 
			if(arg0 != null)
			{
				Access ac = Access.getInstance();
				ac.getAccess().sendRequest(m);
			}
		}
		cle.dispose();
		cle = null;
	}

	public String GenerateXML(int i)
	{
		List choiceList = cle.getChoices();
		String xml = "";

		if (event.position == 0) // is moderator
			xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
					" number='" + i + "' choice='" + choiceList.getItem(i) + "'/></request>";				
		else
			xml = Message.requestHeader() + "<addChoiceRequest id='"+event.getEventID() +"'"+
					" number='" + event.position + "' choice='" + choiceList.getItem(i) + "'/></request>";	


		return xml;
	}

}