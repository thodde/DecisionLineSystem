package controller;

import java.util.Vector;

import model.*;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import view.ChoiceListEditor;
import view.EdgeDisplayForm;
import xml.*;

/**
 * This class takes charge of the SignInResponse, it stores the information into event entity,
 * It can handle the SignInResponse
 * @author Hang, Wei
 */
public class ValidateCredentialsResponseController {
	public ValidateCredentialsResponseController(){
	
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
		
		String mode = map.getNamedItem("mode").getNodeValue();
		System.out.println("mode: " + mode);
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
			event.setChoice(index, choice);
			vc.add(choice);
			System.out.println("choice"+index+" is:"+ choice);
			event.setChoice(index, choice);
		}
		
		/*	//get the first choice ie. choice 0
		node = node.getFirstChild();
		map = node.getAttributes();
		Vector<String> vc = new Vector<String>();
		int i;
		String choice = map.getNamedItem("value").getNodeValue();
		vc.add(choice);
		System.out.println("choice0 is:"+ choice);
		event.setChoice(0, choice);*/
		
		//get the any other choice name
		/*for(i=1;i<option;i++){
			node = node.getNextSibling();
			map = node.getAttributes();
			choice = map.getNamedItem("value").getNodeValue();
			vc.add(choice);
			System.out.println("choice"+i+" is:"+ choice);
			event.setChoice(i, choice);
		}*/
		
		//if this is in open mode, go to the set choice screen
		if(type.equals("open")) {
			ChoiceListEditor acs = new ChoiceListEditor(false);
			acs.setVisible(true);
		}
		//if this in close mode, go the the add edge screen
		else if(type.equals("closed")) {
			EdgeDisplayForm edf = new EdgeDisplayForm();
			edf.setVisible(true);
		}
	}
}
