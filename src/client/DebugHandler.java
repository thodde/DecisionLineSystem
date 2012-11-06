package client;

import xml.Message;

/**
 * This class lets us know when messages are received from the server
 * for testing purposes
 * @author Trevor Hodde
 */
public class DebugHandler extends HandlerBase {

	/**
	 * This handler simply acts on the message by output its contents to the screen, and then
	 * it continues the delegation chain
	 */
	@Override
	public void process(Message response) {
		System.out.println("Received:" + response);
		
		// continue on to the next one in the chain, as based on superclass behavior
		super.process(response);
	}
}