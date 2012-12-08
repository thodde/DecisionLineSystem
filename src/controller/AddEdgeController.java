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
	
	/**
	 * This constructor takes a reference to the EdgeDisplayForm
	 * so that it can be closed later
	 * @param edf EdgeDisplayForm
	 */
	public AddEdgeController(EdgeDisplayForm edf){
		 this.edf = edf;
	}
	
	/**
	 * If the form detects a mouse click, the XY coordinates are stored
	 * and sent to the server in an AddEdgeRequest
	 */
	public void	mouseClicked(MouseEvent arg) {
		Model model = Model.getModel();
		
		if (!model.getDecisionLinesEvent().getType().equals("closed"))
			return;
		
		int nLastXClick = arg.getX();
		int nLastYClick = arg.getY() + 13;
		int choiceId = decodeChoiceId(nLastXClick);
		String eventId = model.getDecisionLinesEvent().getEventID();
		
		//as long as the click is valid 
		if (Model.getModel().myTurn && nLastYClick > 50 && nLastYClick < 400 && choiceId != -1 && choiceId < model.getDecisionLinesEvent().getNumChoices() - 1) {
			String xmlString = Message.requestHeader() + "<addEdgeRequest id='" + eventId + "' left='" + choiceId
					+ "' right='" + (choiceId+1) + "' height='" + nLastYClick + "' /></request>";
				
			Message m = new Message (xmlString);
			Access ac = Access.getInstance();
			ac.getAccess().sendRequest(m);
		}
	}
	
	/**
	 * This method determines which lines were clicked between and
	 * displays an edge appropriately
	 * @param xClick int the click placement
	 * @return int click position
	 */
	private int decodeChoiceId(int xClick) {
		if(xClick < 20) {
			return -1;
		}
		
		int tempClick = xClick - 20;
		int retVal = tempClick / EdgeDisplayForm.CHOICEWIDTH;

		return retVal;
	}
}
