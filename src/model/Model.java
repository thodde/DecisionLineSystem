package model;

import javax.swing.JFrame;

import view.*;
public class Model {
	private DecisionLinesEvent event;
    private static Model modelInstance = null;
    public boolean myTurn = false;
	
	JFrame j;
    ChoiceListEditor cle;
    
    private Model() {
    	event = null;
	}
    
    public static Model getModel() {
    	if (modelInstance == null)
    	{
    		modelInstance = new Model();
    	}
    	
        return modelInstance;
    }
    
    public DecisionLinesEvent getDecisionLinesEvent() {
    	if (event == null) {
    		event = new DecisionLinesEvent();
    	}	
    	return event;
    }
    
    /**
     * make the DecisionLinesEvent to be inner class in the model
     * @author Hang, Wei
     */
    public void setDecisionLinesEvent (DecisionLinesEvent event) {
		this.event = event;
	}

	/**
	 * This is used for storing and getting the windows;
	 * @author Hang, Wei
	 * @param j
	 */
    //The model should not have a reference to the view
	public void setJFrame(JFrame j) {
		this.j = j;
	}
	
	public JFrame getJFrame() {
		return this.j;
	}
}
