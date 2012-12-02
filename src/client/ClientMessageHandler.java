package client;

import controller.*;
import xml.Message;

/**
 * This class is used for dealing with the response message send from the server;
 * @author Hang, Wei
 *
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
			// What happens now that we are connected? Now do nothing
			//new ConnectController().process(response);
		}
		else if(type.equals("signInResponse")){
			new ValidateCredentialsResponseController().process(response);
		}
		//else if(type.equals("createResponse")){
		//	new modCreateResponseController().process(response);
		//}
		else if(type.equals("addChoiceResponse")){
			new AddChoiceResponseController().process(response);
		}
		else if(type.equals("addEdgeResponse")){
			new AddEdgeResponseController().process(response);
		}
		//else if(type.equals("TurnResponse")){
		//	new TurnResponseController().process(response);
		//}
	
	}
}

