package view;

import model.Model;
import junit.framework.TestCase;

public class TestEdgeDisplayForm extends TestCase {
	public void testEdgeDisplayForm() {
		Model model = new Model();
		EdgeDisplayForm edf = new EdgeDisplayForm(model, true);
		
		model.nOptionCount = 0;
		edf.getOptionXCoord(null, 0);
		
		model.nOptionCount = 2;
		edf.getOptionXCoord(null, 0);
		
		edf.getClickOptionIndex(0);
	}
}
