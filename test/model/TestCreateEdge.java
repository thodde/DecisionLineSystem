package model;

import junit.framework.TestCase;

public class TestCreateEdge extends TestCase {

	public void testEdge() {
		Edge e = new Edge(5,4,23);
		assertEquals(e.getLeft(),5);
		assertEquals(e.getRight(),4);
		assertEquals(e.getHeight(),23);

		Edge e2 = new Edge(5,4,25);
		assertTrue(e.conflictsWith(e2));
		
		Edge e4 = new Edge(5,4,30);
		assertTrue(e.conflictsWith(e4));
		
		Edge e5 = new Edge(5,4,31);
		assertFalse(e.conflictsWith(e5));
	}
}
