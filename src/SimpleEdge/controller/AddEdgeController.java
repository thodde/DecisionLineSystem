package SimpleEdge.controller;

import SimpleEdge.model.Model;
import SimpleEdge.view.EdgeDisplayPanel;

public class AddEdgeController {

	Model model;
	EdgeDisplayPanel panel;

	public AddEdgeController(Model m, EdgeDisplayPanel p) {
		model = m;
		panel = p;
	
	}

	public void ProcessEdgeAddition() {

		int index = panel.GetClickOptionIndex(panel.nLastXClick);

		if (index >= 0 && index < model.nOptionCount) {
			model.addNewEdge(index, panel.nLastXClick, panel.nLastYClick);
			panel.repaint();
		}
	}
}

