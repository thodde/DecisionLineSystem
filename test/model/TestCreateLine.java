package model;

import junit.framework.TestCase;

public class TestCreateLine extends TestCase {
	public void testCreateLine(){
		Line line = new Line("Apple", 3);
		
		//assertEquals(line.getTotalEdgeCount(),5);
		assertEquals(line.getLinePosition(),3);
		assertTrue(line.getChoice().equals("Apple"));
		assertEquals(line.getCurrentCount(),0);
		
		Edge e = new Edge(3,4,50);
		assertEquals(line.isValidNewEdge(e),true);
		
		assertEquals(line.addEdge(e),true);
		assertEquals(line.getCurrentCount(),1);
		
		Edge eGood = new Edge(4,5,150);
		Edge eBad = new Edge(3,4,50);

		assertEquals(line.isValidNewEdge(eGood),true);
		assertEquals(line.isValidNewEdge(eBad),false);

		assertEquals(line.addEdge(eGood),true);
		assertEquals(line.addEdge(eBad),false);
		assertEquals(line.getCurrentCount(),2);
	}
}
