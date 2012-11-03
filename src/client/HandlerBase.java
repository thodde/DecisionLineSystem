package client;

import xml.Message;

public abstract class HandlerBase implements IMessageHandler {

	protected HandlerBase successor;
	
	public void setSuccessor (HandlerBase successor) {
		this.successor = successor;
	}
	
	/**
	 * This method is to be overridden by subclasses. The default behavior is
	 * simply to pass the request on to the successor.
	 */
	public void process(Message response) {
		if (successor != null) {
			successor.process(response);
		}
	}
}