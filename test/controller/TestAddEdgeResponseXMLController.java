package controller;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.DecisionLinesEvent;
import model.Edge;
import model.Line;
import model.Model;

import view.EdgeDisplayForm;
import xml.Message;
import junit.framework.TestCase;

public class TestAddEdgeResponseXMLController extends TestCase {
	
	
	/**test add edge response
	 * @author mpeltola
	 */
	public void testAddEdgeResponse() {

		Model m = Model.getModel();
		
		assertTrue (Message.configure("draw2choose.xsd"));

		EdgeDisplayForm edf =  new EdgeDisplayForm();

		m.setJFrame(edf);

		DecisionLinesEvent event = DecisionLinesEvent.getInstance();

		event.setNumChoices(2);
		Line l1 = new Line("Today",0);    
		event.setChoice(l1);

		Line l2 = new Line("Tomorrow",1);
		event.setChoice(l2);

		String inputXML0  = "<?xml version='1.0' encoding='UTF-8'?><response id='d4791128-68c3-45c0-81c3-6c767e22d974' success='true'><addEdgeResponse height='156' id='ac67a755-f9fe-4ff7-a253-a089213c8ce3' left='0' right='1'/></response>";
		String inputXML1  = "<?xml version='1.0' encoding='UTF-8'?><response id='8504fe50-4952-47fb-8b03-60b17cbb3107' success='true'><addEdgeResponse height='292' id='ac67a755-f9fe-4ff7-a253-a089213c8ce3' left='0' right='1'/></response>";

		Message m0 = new Message(inputXML0);
		Message m1 = new Message(inputXML1);

		event.setEventID("c67a755-f9fe-4ff7-a253-a089213c8ce3");

		AddEdgeResponseXMLController aerXtrllr = new AddEdgeResponseXMLController();

		aerXtrllr.process(m0);
		aerXtrllr.process(m1);

		ArrayList<Edge> edges = event.getEdges();


		assertEquals(2 , edges.size());

		Edge e0 = edges.get(0);
		Edge e1 = edges.get(1);

		assertEquals(156 , e0.getHeight());
		assertEquals(292 , e1.getHeight());

	}
}
