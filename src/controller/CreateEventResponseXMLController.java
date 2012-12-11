package controller;

import model.Access;
import model.Model;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import xml.Message;
import client.IMessageHandler;

/**
 * This class handles XML responses from the server when
 * the moderator requests to create an event
 * @author Trevor Hodde
 */
public class CreateEventResponseXMLController implements IMessageHandler {
	@Override
	public void process(Message response) {
		Node node = response.contents.getFirstChild();
		NamedNodeMap map = node.getAttributes();
		String id = map.getNamedItem("id").getNodeValue();
		System.out.println("id:" + id);
		
		//Everything below is used to grab the username and password from the model
		//and build the signIn to sign the moderator right into the event instead of
		//creating the event and then signing in as a user
		Model model = Model.getModel();
		
		String xmlString = Message.requestHeader() + "<signInRequest id='" + id + "'>"+
				"<user name='"+ model.getUsername() + "' password='" + model.getPassword() + "'/>" +
				"</signInRequest></request>";
		
		Message m = new Message (xmlString);
		Access ac = Access.getInstance();
		ac.getAccess().sendRequest(m);
	}
}
