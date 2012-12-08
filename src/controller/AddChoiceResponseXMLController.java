package controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.IMessageHandler;

import view.EdgeDisplayForm;
import xml.Message;
import model.*;

public class AddChoiceResponseXMLController implements IMessageHandler {
	
	public void process(Message response) {
		boolean hasAllValues = true;
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
			
			for(int i = 0; i < event.choices.length; i++) {
				if(event.choices[i] == null) {
					hasAllValues = false;
				}
			}
			
			if(hasAllValues) {
				EdgeDisplayForm edf = new EdgeDisplayForm();
				edf.setVisible(true);
			}
		}
	}
}
