package controller;


import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.IMessageHandler;

import view.ChoiceListEditor;
import view.EdgeDisplayForm;
import xml.Message;
import model.*;

/**
 * This class is used for dealing with the addChoiceResponse, it will store the information into event
 * @author Hang, Wei
 */
public class AddChoiceResponseXMLController implements IMessageHandler {
	public void process(Message response) {
		Model model = Model.getModel();
		DecisionLinesEvent event = Model.getModel().getDecisionLinesEvent();
		Node node = response.contents.getFirstChild();
		NamedNodeMap map = node.getAttributes();
		String id = map.getNamedItem("id").getNodeValue();
		String choice = map.getNamedItem("choice").getNodeValue();
		String num = map.getNamedItem("number").getNodeValue();
		//check if the id equals to the EventID
		if(id.equals(event.getEventID())) {
			//if this number of choice is not added
			int number = Integer.parseInt(num);
			event.setChoice(number, choice);
			System.out.println(num+choice);
			//((ChoiceListEditor) model.getJFrame()).refreshChoiceList();
			// if all the choices have been added
			/*
			if(event.getOption() == number) {
				((ChoiceListEditor) model.getJFrame()).dispose();
				EdgeDisplayForm edf = new EdgeDisplayForm();
				edf.setVisible(true);
			}
			*/
			EdgeDisplayForm edf = new EdgeDisplayForm();
			edf.setVisible(true);
		}
	}
}
