package controller;

import model.Model;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import view.EdgeDisplayForm;
import xml.Message;
import client.IMessageHandler;

public class JoinResponseXMLController implements IMessageHandler {

	@Override
	public void process(Message response) {
		Node node = response.contents.getFirstChild();
		NodeList list = node.getChildNodes();
		for (int index = 0; index < list.getLength(); index++) {
			Node n = list.item(index);
			if (n.getNodeName().equals("user")) {
				if (!Model.getModel().connectedUsers.contains(n.getAttributes().getNamedItem("name").getNodeValue()))
					Model.getModel().connectedUsers.add(n.getAttributes().getNamedItem("name").getNodeValue());
			}
		}

		if (Model.getModel().getJFrame() != null)
			if (Model.getModel().getJFrame() instanceof EdgeDisplayForm)
				((EdgeDisplayForm) Model.getModel().getJFrame()).redraw();
	}

}
