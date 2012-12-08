package client;

import controller.*;
import xml.Message;

/**
 * This class is used for dealing with the response message send from the server;
 * @author Hang, Wei
 */
public class ClientMessageHandler implements IMessageHandler {

	/**
	 * This handler simply acts on the message by output its contents to the screen, and then
	 * it continues the delegation chain
	 */
	@Override
	public void process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();

		if (type.equals ("connectResponse")) {
			//new ConnectController().process(response);
		}
		else if(type.equals("signInResponse")){
			new ValidateCredentialsResponseXMLController().process(response);
		}
		else if(type.equals("createResponse")){
			new CreateEventResponseXMLController().process(response);
		}
		else if(type.equals("addChoiceResponse")){
			new AddChoiceResponseXMLController().process(response);
		}
		else if(type.equals("addEdgeResponse")){
			new AddEdgeResponseXMLController().process(response);
		}
		else if(type.equals("turnResponse")){
			new TurnResponseXMLController().process(response);
		}
	}
}

