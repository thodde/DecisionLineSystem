package controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.*;
import model.Model;
import view.EdgeDisplayForm;
import xml.Message;

/**
 * This class allows the user to add an edge to the DecisionLineSystem event board
 * @author Trevor Hodde
 */
public class AddEdgeController implements IController {
	Model model;
	EdgeDisplayForm form;

	/**
	 * @author jforkey, mpeltola, thodde
	 * @param m model to be given to controller
	 * @param edgeDisplayFrame panel to display
	 */
	public AddEdgeController(Model m, EdgeDisplayForm edf) {
		this.model = m;
		this.form = edf;
	}

	/**
	 * @author Hang, Wei.
	 * This realize the send and receive message from the Sever, and after receive the message, we refresh the panel.
	 */
	public void processEdgeAddition() {	
		Message m = requestProcess();	
	}
	
	
	public Message requestProcess() {
		String eventId=model.getEventID();
		String request = Message.requestHeader();
		request += "<addEdgeResponse id='"+eventId+"' left='"+Model.Left+"' right='"+Model.Right+"' height='"+form.nLastYClick+"' /></request>";
		return new Message(request);
	}
	
	@Override
	public void process(Message m, Message response) {
		Node addEdgeResponse = response.contents.getFirstChild();
		Node addEdgeRequest = response.contents.getFirstChild();
		NamedNodeMap map2 = addEdgeRequest.getAttributes();
		NamedNodeMap map = addEdgeResponse.getAttributes();
		
		String eventId = map.getNamedItem("id").getNodeValue();
		String eventId2 = map2.getNamedItem("id").getNodeValue();
		Boolean flag =  Boolean.valueOf(map.getNamedItem("success").getNodeValue());
		if(eventId == eventId2 ){
			if (flag == true){
				int index = form.getClickOptionIndex(form.nLastXClick);
				model.addNewEdge(index, form.nLastXClick, form.nLastYClick);
				form.repaint();
			}
		}
	}
}
