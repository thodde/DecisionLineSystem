package client;

import xml.Message;
import junit.framework.TestCase;

public class TestDebugHandler extends TestCase {
	public void testDebugHandler() {
		DebugHandler dh = new DebugHandler();
		Message.configure("draw2choose.xsd");
		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
		Message m = new Message (xmlString);
		dh.process(m);
		dh.setSuccessor(null);
		
		Message.responseHeader(xmlString);
		String reason = m.reason();
		String id = m.id();
		Message.responseHeader(id, reason);
	}
}
