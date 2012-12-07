package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Access;
import model.Model;
import view.EdgeDisplayForm;
import xml.Message;

/**
 * This class is used for sending the addEdgeRequest message to the server
 * @author Hang, Wei
 */
public class AddEdgeController extends MouseAdapter{
	EdgeDisplayForm edf;
	
	public AddEdgeController(EdgeDisplayForm edf){
		 this.edf = edf;
	}
	
	public void	mouseClicked(MouseEvent arg) {
		Model model = Model.getModel();
		int nLastXClick = arg.getX();
		int nLastYClick = arg.getY();
		int choiceId = decodeChoiceId(nLastXClick, nLastYClick);
		String eventId = model.getDecisionLinesEvent().getEventID();
		// convert to the char[] to String
		//TODO This is the right idea, send it to an XML string and DO NOT write it to the model just yet
		// but first you must verify that the height is valid 
		String xmlString = Message.requestHeader()+"<addEdgeRequest id='"+eventId+"' left='"+ choiceId
			+"' right='"+(choiceId+1)+"' height='"+ nLastYClick+"' /></request>";;

		Message m = new Message (xmlString);
		// get the ServerAccess, then send the request
		Access ac = Access.getInstance();
		ac.getAccess().sendRequest(m);
	}
	
	//TODO code
	private int decodeChoiceId(int xClick, int yClick) {
		return 0;
	}
}
