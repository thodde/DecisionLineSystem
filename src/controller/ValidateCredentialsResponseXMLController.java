package controller;

import java.util.Vector;

import model.*;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import client.IMessageHandler;

import view.ChoiceListEditor;
import view.EdgeDisplayForm;
import xml.*;

/**
 * This class takes charge of the SignInResponse, it stores the information into event entity,
 * It can handle the SignInResponse
 * @author Hang, Wei
 */
public class ValidateCredentialsResponseXMLController implements IMessageHandler {
	public ValidateCredentialsResponseXMLController(){
	
	}
	public void process(Message response) {
		Model model = Model.getModel();
		DecisionLinesEvent event = model.getDecisionLinesEvent();
		//get the event information
		Node node = response.contents.getFirstChild();
		NamedNodeMap map = node.getAttributes();
		String id = map.getNamedItem("id").getNodeValue();
		System.out.println("id:" + id);
		event.setEventID(id);

		String type = map.getNamedItem("type").getNodeValue();
		System.out.println("type: " + type);
		event.setType(type);
		
		String mode = map.getNamedItem("behavior").getNodeValue();
		System.out.println("behavior: " + mode);
		event.setMode(mode);
		
		String name = map.getNamedItem("question").getNodeValue();
		System.out.println("name: "+ name);
		event.setQuestion(name);
		
		String numchoices = map.getNamedItem("numChoices").getNodeValue();
		int option = Integer.parseInt(numchoices);
		System.out.println("number of choices: "+numchoices);
		event.setOption(option);
		
		String numRounds = map.getNamedItem("numRounds").getNodeValue();
		int q = Integer.parseInt(numRounds);
		System.out.println("number of Round: " + numRounds);
		event.setRounds(q);
		
		String p = map.getNamedItem("position").getNodeValue();
		int position = Integer.parseInt(p);
		System.out.println("this user's position is: " +p);
		event.setPosition(position);
		
	    //get the every choice in the XML message to store into evnet.choice
		Vector<String> vc = new Vector<String>();
		NodeList list = node.getChildNodes();
		for (int index = 0; index < list.getLength(); index++) {
			Node n = list.item(index);
			String choice = n.getAttributes().getNamedItem("value").getNodeValue();
			int valIndex = Integer.parseInt(n.getAttributes().getNamedItem("index").getNodeValue());
			event.setChoice(valIndex, choice);
			vc.add(choice);
			System.out.println("choice"+valIndex+" is:"+ choice);
			event.setChoice(index, choice);
		}
		
		if (position == 0) { // user is the moderator
			boolean hasAllChoices = true;
			for (int i = 0; i < option; i++) 
				if (event.choices.get(i) == null)
					hasAllChoices = false;
			
			if (!hasAllChoices) {
				//ChoiceListEditor acs = new ChoiceListEditor(false, event);
				//acs.setVisible(true);
				return;
			}
		}
		else { //user is not a moderator
			if (type.equals("open") && event.choices.get(position) == null) { 
				//ChoiceListEditor acs = new ChoiceListEditor(false, event);
				//acs.setVisible(true);
				return;
			}
		}
		
		//goto edge screen
		EdgeDisplayForm edf = new EdgeDisplayForm();
		edf.setVisible(true);
	}
}
