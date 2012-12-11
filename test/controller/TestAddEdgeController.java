package controller;

import java.awt.event.MouseEvent;

import view.EdgeDisplayForm;
import xml.Message;
import model.DecisionLinesEvent;
import model.Line;
import model.Model;
import junit.framework.TestCase;

public class TestAddEdgeController extends TestCase {
	

	public void setupEvent() {
		
		Model model = Model.getModel();
		 
		model.myTurn = true;
		DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
		
		dle.setQuestion("Why now?");
		dle.setMode("roundRobin");
		dle.setType("closed");
		dle.setRounds(2);
		dle.setNumChoices(3);
		
		Line choice1 = new Line("Apple", 0);
		dle.setChoice(choice1);

		Line choice2 = new Line("Orange", 0);
		dle.setChoice(choice2);

		Line choice3 = new Line("Cherry", 0);
		dle.setChoice(choice2);

		model.connectedUsers.add("Bob");
		model.connectedUsers.add("Rita");
		model.connectedUsers.add("Sam");
	}
	
	



	public void testAddEdgeControllerClickNotTurn() {

		setupEvent();
		Model model = Model.getModel();
		
		model.myTurn = false;
		//model.connectedUsers.remove("Sam");
		
		EdgeDisplayForm edf = new EdgeDisplayForm();
		
		DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
		
		AddEdgeController aec = new AddEdgeController(edf);
		
		int x = 130;
		int y = 100;
		
		MouseEvent arg = new MouseEvent(edf, 0, 0, 0, x, y, 0, false);
		
		aec.mouseClicked(arg);
		
		String g = aec.xmlString;
		System.out.println(g);
		
		
	}

	
	public void testAddEdgeControllerClickMissingPlayer() {

		setupEvent();
		Model model = Model.getModel();
		
		//model.myTurn = false;
		model.connectedUsers.remove("Sam");
		
		EdgeDisplayForm edf = new EdgeDisplayForm();
		
		DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
		
		AddEdgeController aec = new AddEdgeController(edf);
		
		int x = 130;
		int y = 100;
		
		MouseEvent arg = new MouseEvent(edf, 0, 0, 0, x, y, 0, false);
		
		aec.mouseClicked(arg);
		
		String g = aec.xmlString;
		System.out.println(g);
		
	}

	public void testAddEdgeControllerClickBadYValue() {

		setupEvent();
		Model model = Model.getModel();
		
		//model.myTurn = false;
		model.connectedUsers.remove("Sam");
		
		EdgeDisplayForm edf = new EdgeDisplayForm();
		
		DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
		
		AddEdgeController aec = new AddEdgeController(edf);
		
		int x = 130;
		int y = 5;
		
		MouseEvent arg = new MouseEvent(edf, 0, 0, 0, x, y, 0, false);
		
		aec.mouseClicked(arg);
		
		String g = aec.xmlString;
		System.out.println(g);
		
	}

	

}
