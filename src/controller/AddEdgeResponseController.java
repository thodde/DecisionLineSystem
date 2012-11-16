package controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


import model.Model;
import view.EdgeDisplayForm;
import xml.Message;

/**
 * This realize the send and receive message from the Sever, and after receive the message, we refresh the pane.
 * @author Hang, Wei
 *
 */

public class AddEdgeResponseController{
	Model model;
	EdgeDisplayForm form;

	public void process(Message response){
		form = (EdgeDisplayForm)model.getJFrame();
		Node addEdgeResponse = response.contents.getFirstChild();
		NamedNodeMap map = addEdgeResponse.getAttributes();		
		Boolean flag =  Boolean.valueOf(map.getNamedItem("success").getNodeValue());
			if (flag == true){
				int index = form.getClickOptionIndex(form.nLastXClick);
				model.addNewEdge(index, form.nLastXClick, form.nLastYClick);
				form.repaint();
				model.setJFrame(form);
			}
		
	}
}

