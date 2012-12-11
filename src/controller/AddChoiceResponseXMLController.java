package controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.IMessageHandler;

import view.EdgeDisplayForm;
import xml.Message;
import model.*;

/**
 * This class gets XML responses from the server
 * when users add choices to Decision Line Events
 * @author Trevor Hodde
 */
public class AddChoiceResponseXMLController implements IMessageHandler {
	
	/**
	 * This method handles the response from the server when a user adds
	 * a choice to an event
	 * @param Message response from the server
	 */
	public void process(Message response) {
		boolean createEdgeDisplayForm = false;
		DecisionLinesEvent event = DecisionLinesEvent.getInstance();
		Node node = response.contents.getFirstChild();
		NamedNodeMap map = node.getAttributes();
		String id = map.getNamedItem("id").getNodeValue();
		String choice = map.getNamedItem("choice").getNodeValue();
		String num = map.getNamedItem("number").getNodeValue();
		//check if the id equals to the EventID
		if(id.equals(event.getEventID())) {
			//if this number of choice is not added
			int number = Integer.parseInt(num);
			Line newChoice = new Line(choice, number);
			event.setChoice(newChoice);
			System.out.println(num+choice);
			
			if (Model.getModel().getJFrame() == null)
				createEdgeDisplayForm = true;
			else if (Model.getModel().getJFrame() instanceof EdgeDisplayForm)
				((EdgeDisplayForm) Model.getModel().getJFrame()).redraw();
			else
				createEdgeDisplayForm = true;

			if(createEdgeDisplayForm) {
				EdgeDisplayForm edf = new EdgeDisplayForm();
				edf.setVisible(true);
				Model.getModel().setJFrame(edf);
			}
		}
	}
}
