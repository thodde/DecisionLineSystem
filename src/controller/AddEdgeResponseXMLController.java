package controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.IMessageHandler;

import model.DecisionLinesEvent;
import model.Edge;
import model.Model;
import view.EdgeDisplayForm;
import xml.Message;

/**
 * This realize the send and receive message from the Sever, and after receive the message, we refresh the pane.
 * @author Hang, Wei
 */
public class AddEdgeResponseXMLController implements IMessageHandler {
	Model model;
	EdgeDisplayForm form;

	/**
	 * This method processes XML responses from the server
	 * when a user adds an edge to a DLE
	 * @param Message response an XML response from the server
	 */
	public void process(Message response) {
		model = Model.getModel();
		form = (EdgeDisplayForm) model.getJFrame();
		NamedNodeMap map = response.contents.getAttributes();		
		Boolean flag =  Boolean.valueOf(map.getNamedItem("success").getNodeValue());
		Node addEdgeResponse = response.contents.getFirstChild();
		if (flag == true) {
			if(Model.getModel().getDecisionLinesEvent().getMode().equals("roundRobin")) {
				Model.getModel().myTurn = false;
			}
			
			int left = Integer.parseInt(addEdgeResponse.getAttributes().getNamedItem("left").getNodeValue());
			int right = Integer.parseInt(addEdgeResponse.getAttributes().getNamedItem("right").getNodeValue());
			int height = Integer.parseInt(addEdgeResponse.getAttributes().getNamedItem("height").getNodeValue());
			
			Edge newEdge = new Edge(left, right, height);
			DecisionLinesEvent event = model.getDecisionLinesEvent();
			
			if (!event.getEdges().contains(newEdge))
				model.getDecisionLinesEvent().getEdges().add(newEdge);
			
			form.repaint();
		}
	}
}

