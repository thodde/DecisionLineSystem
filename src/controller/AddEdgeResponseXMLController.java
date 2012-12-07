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

	public void process(Message response) {
		form = (EdgeDisplayForm)model.getJFrame();
		Node addEdgeResponse = response.contents.getFirstChild();
		NamedNodeMap map = addEdgeResponse.getAttributes();		
		Boolean flag =  Boolean.valueOf(map.getNamedItem("success").getNodeValue());
		if (flag == true) {
			//TODO no, this is wrong.  Take the settings from the XML message itself, not stored locally on the form
			/*
			int index = form.getClickOptionIndex(form.nLastXClick);
			model.addNewEdge(index, form.nLastXClick, form.nLastYClick);
			*/
			addEdgeResponse = addEdgeResponse.getNextSibling();
			int left = Integer.parseInt(addEdgeResponse.getAttributes().getNamedItem("left").getNodeValue());
			int right = Integer.parseInt(addEdgeResponse.getAttributes().getNamedItem("right").getNodeValue());
			int height = Integer.parseInt(addEdgeResponse.getAttributes().getNamedItem("height").getNodeValue());
			
			Edge newEdge = new Edge(left, right, height);
			DecisionLinesEvent event = model.getDecisionLinesEvent();
			
			// Does this exist in the Decision line event already?
			if (!event.getEdges().contains(newEdge))
				model.getDecisionLinesEvent().getEdges().add(newEdge);
			
			form.repaint();
			model.setJFrame(form);
		}
	}
}

