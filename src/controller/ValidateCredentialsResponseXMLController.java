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
	public ValidateCredentialsResponseXMLController() {
	
	}
	
	/**
	 * This method takes all the info from the server response
	 */
	public void process(Message response) {
		Model model = Model.getModel();
		DecisionLinesEvent event = model.getDecisionLinesEvent();
		//get the event information
		Node node = response.contents.getFirstChild();
		NamedNodeMap map = node.getAttributes();
		String id = map.getNamedItem("id").getNodeValue();
		System.out.println("id:" + id);
		event.setEventID(id);

		//Type is open or closed
		String type = map.getNamedItem("type").getNodeValue();
		event.setType(type);
		
		//Mode is round robin or asynch
		String mode = map.getNamedItem("behavior").getNodeValue();
		event.setMode(mode);
		
		String name = map.getNamedItem("question").getNodeValue();
		event.setQuestion(name);
		
		String numChoices = map.getNamedItem("numChoices").getNodeValue();
		int option = Integer.parseInt(numChoices);
		event.setNumChoices(option);
		
		String numRounds = map.getNamedItem("numRounds").getNodeValue();
		int q = Integer.parseInt(numRounds);
		event.setRounds(q);
		
		String p = map.getNamedItem("position").getNodeValue();
		int position = Integer.parseInt(p);
		event.setPosition(position);
		
	    //get the every choice in the XML message to store into event.choice
		Vector<String> vc = new Vector<String>();
		NodeList list = node.getChildNodes();
		for (int index = 0; index < list.getLength(); index++) {
			Node n = list.item(index);
			if(n.getNodeName().equals("choice")) {
				String choice = n.getAttributes().getNamedItem("value").getNodeValue();
				int valIndex = Integer.parseInt(n.getAttributes().getNamedItem("index").getNodeValue());
				event.setChoice(valIndex, choice);
				vc.add(choice);
				event.setChoice(index, choice);
			}
		}
		
		if (position == 0) { // user is the moderator
			boolean hasAllChoices = true;
			Model.getModel().myTurn = true;
			
			for (int i = 0; i < option; i++) 
				if (event.choices[i] == null)
					hasAllChoices = false;
			
			if (!hasAllChoices) {
				ChoiceListEditor cle = new ChoiceListEditor();
				cle.setVisible(true);
				return;
			}
		}
		else { //user is not a moderator
			if (type.equals("open") && event.choices[position] == null) {
				ChoiceListEditor cle = new ChoiceListEditor();
				cle.setVisible(true);
				return;
			}
		}
		
		//goto edge screen
		EdgeDisplayForm edf = new EdgeDisplayForm();
		edf.setVisible(true);
	}
}
