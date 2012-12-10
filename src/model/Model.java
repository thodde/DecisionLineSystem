package model;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Model {
	private DecisionLinesEvent event;
    private static Model modelInstance = null;
    public boolean myTurn = false;
    public ArrayList<String> connectedUsers;
	
	JFrame j;
    
    private Model() {
    	event = null;
    	connectedUsers = new ArrayList<String>();
	}
    
    public static Model getModel() {
    	if (modelInstance == null)
    	{
    		modelInstance = new Model();
    	}
    	
        return modelInstance;
    }
    
    public DecisionLinesEvent getDecisionLinesEvent() {
    	return DecisionLinesEvent.getInstance();
    }
    
    /**
     * make the DecisionLinesEvent to be inner class in the model
     * @author Hang, Wei
     */
    public void setDecisionLinesEvent (DecisionLinesEvent event) {
		this.event = event;
	}
    
    public void setUsername(String username) {
    	Model.getModel().getDecisionLinesEvent().setUsername(username);
    }
    
    public String getUsername() {
    	return Model.getModel().getDecisionLinesEvent().getUsername();
    }
    
    public void setPassword(String password) {
    	Model.getModel().getDecisionLinesEvent().setPassword(password);
    }
    
    public String getPassword() {
    	return Model.getModel().getDecisionLinesEvent().getPassword();
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
