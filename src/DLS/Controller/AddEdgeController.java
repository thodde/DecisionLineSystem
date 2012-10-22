package DLS.Controller;

import DLS.model.Model;
import DLS.view.EdgeDisplayPanel;

//====================================================================
//This class places a new edge addition into the model
//Rev 1  -M. Peltola   7-Oct-2012 Class created 
//====================================================================
public class AddEdgeController {

	Model model;
	EdgeDisplayPanel panel;

	//====================================================================
	//The constructor stores a reference to the model and UI
	//Rev 1  -M. Peltola   07-Oct-2012 Class created 
	//====================================================================
	public AddEdgeController(Model m, EdgeDisplayPanel p) {
		model = m;
		panel = p;
	}

	//====================================================================
	//This method adds a new edge to the model
	//Rev 1  -M. Peltola   07-Oct-2012 Class created 
	//====================================================================
	public void processEdgeAddition() {

		int index = panel.GetClickOptionIndex(panel.nLastXClick);

		if (index >= 0 && index < model.nOptionCount) {
			model.addNewEdge(index, panel.nLastXClick, panel.nLastYClick);
			panel.repaint();
		}
	}
}

