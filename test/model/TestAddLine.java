package model;

import junit.framework.TestCase;

public class TestAddLine extends TestCase {

	public void testLine() {
		int numRounds = 2;
		int numChoices = 3;
		int totalEdgeCount = numRounds*numChoices;
		
		Line line = new Line(totalEdgeCount,"Apple", 3);
		
		assertEquals(line.getTotalEdgeCount(),totalEdgeCount);
		assertEquals(line.getLinePosition(),3);
		assertEquals(line.getChoice(),"Apple");
		assertEquals(line.getCurrentCount(),0);
		
		Edge eGood1 = new Edge(3,4,50);
		assertEquals(line.isValidNewEdge(eGood1),true);
		
		assertEquals(line.addEdge(eGood1),true);
		assertEquals(line.getCurrentCount(),1);
		
		Edge eBad = new Edge(3,4,50);
		assertEquals(line.isValidNewEdge(eBad),false);
		assertEquals(line.addEdge(eBad),false);
		
		Edge eGood2 = new Edge(4,5,150);
		assertEquals(line.isValidNewEdge(eGood2),true);
		
		assertEquals(line.addEdge(eGood2),true);

		assertEquals(line.getCurrentCount(),2);
		
		Edge eGood3 = new Edge(4,5,350);
		assertEquals(line.addEdge(eGood3),true);

		Edge eGood4 = new Edge(4,5,200);
		assertEquals(line.addEdge(eGood4),true);

		Edge eGood5 = new Edge(4,5,175);
		assertEquals(line.addEdge(eGood5),true);

		Edge eGood6 = new Edge(4,5,400);
		assertEquals(line.addEdge(eGood6),true);
	}
}
