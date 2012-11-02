package DLS.Controller.View;

import DLS.model.Model;
import DLS.view.EdgeDisplayFrame;
import DLS.view.EdgeDisplayPanel;

//====================================================================
//This class places a new edge addition into the model
//Rev 1  -M. Peltola   7-Oct-2012 Class created 
//====================================================================

public class AddEdgeController {

	Model model;
	EdgeDisplayPanel panel;

	/**
	 * @author jforkey, mpeltola, thodde
	 * @param m model to be given to controller
	 * @param edgeDisplayFrame panel to display
	 */
	public AddEdgeController(Model m, EdgeDisplayPanel edgeDisplayPanel) {
		model = m;
		panel = edgeDisplayPanel;
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

