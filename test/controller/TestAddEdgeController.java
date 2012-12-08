package controller;

import view.EdgeDisplayForm;
import xml.Message;
import model.Model;
import junit.framework.TestCase;

public class TestAddEdgeController extends TestCase {
	public void testAddEdgeController() {
		Model model = Model.getModel();
		Message.configure("draw2choose.xsd");
		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
		Message m = new Message (xmlString);
		//MAP202 AddEdgeController aec = new AddEdgeController(model, new EdgeDisplayForm(model, false));
	}
}
