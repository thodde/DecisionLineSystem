package controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import xml.Message;
import client.IMessageHandler;

public class CreateEventResponseXMLController implements IMessageHandler {
	@Override
	public void process(Message response) {
		Node node = response.contents.getFirstChild();
		NamedNodeMap map = node.getAttributes();
		String id = map.getNamedItem("id").getNodeValue();
		System.out.println("id:" + id);
	}
}
