package controller;

import java.awt.event.MouseEvent;

import model.DecisionLinesEvent;
import model.Model;

import view.EdgeDisplayForm;
import junit.framework.TestCase;

public class TestAddEdgeResponseXMLController extends TestCase {
	public void testAddEdgeResponse() {
		EdgeDisplayForm edf = new EdgeDisplayForm();
		AddEdgeController aec = new AddEdgeController(edf);
		
		DecisionLinesEvent dle = new DecisionLinesEvent();
		Model.getModel().setDecisionLinesEvent(dle);
		dle.setType("closed");
		
		aec.mouseClicked(new MouseEvent(edf, 0, 0, 0, 0, 0, 0, false));
	}
}
