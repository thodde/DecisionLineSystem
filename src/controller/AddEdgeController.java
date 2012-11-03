package controller;

import model.Model;
import view.EdgeDisplayForm;

public class AddEdgeController {

	Model model;
	EdgeDisplayForm form;

	/**
	 * @author jforkey, mpeltola, thodde
	 * @param m model to be given to controller
	 * @param edgeDisplayFrame panel to display
	 */
	public AddEdgeController(Model m, EdgeDisplayForm edf) {
		this.model = m;
		this.form = edf;
	}

	/**
	 * This method adds a new edge to the form
	 */
	public void processEdgeAddition() {

		int index = form.GetClickOptionIndex(form.nLastXClick);

		if (index >= 0 && index < model.nOptionCount) {
			model.addNewEdge(index, form.nLastXClick, form.nLastYClick);
			form.repaint();
		}
	}
}

