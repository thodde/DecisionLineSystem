package view;

import model.Model;
import junit.framework.TestCase;

public class TestSimpleEdge extends TestCase {
	public void testSimpleEdge() {
		Model model = Model.getModel();
		SimpleEdge se = new SimpleEdge(model);
	}
}
