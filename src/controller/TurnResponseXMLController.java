package controller;

import model.Model;
import org.w3c.dom.Node;
import xml.Message;
import client.IMessageHandler;

/**
 * This class is used for determining whose turn it is currently
 * or if the game is over
 * @author Trevor Hodde
 */
public class TurnResponseXMLController implements IMessageHandler {
	
	/**
	 * This method gets a response from the user to determine whose turn it is or
	 * if the game has ended
	 */
	@Override
	public void process(Message response) {
		Node turnResponse = response.contents.getFirstChild();
		boolean gameOver = Boolean.parseBoolean(turnResponse.getAttributes().getNamedItem("completed").getNodeValue());
		
		//if the game is over, it is no longer the clients turn
		if(gameOver) {
			Model.getModel().myTurn = false;
		}
		else { //otherwise, it is the clients turn
			Model.getModel().myTurn = true;
		}
	}
}
