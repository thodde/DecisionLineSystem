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
    
    /**
     * Makes the Model object a singleton
     * @return the instance of the Model
     */
    public static Model getModel() {
    	if (modelInstance == null) {
    		modelInstance = new Model();
    	}
    	
        return modelInstance;
    }
    
    /**
     * Returns an instance of the current DecisionLinesEvent
     */
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
    
    /**
     * Allows setting the user name through the Model
     * @param username the name of the user
     */
    public void setUsername(String username) {
    	Model.getModel().getDecisionLinesEvent().setUsername(username);
    }
    
    /**
     * Gets the user name from the current DecisionLinesEvent
     * @return the name of the user
     */
    public String getUsername() {
    	return Model.getModel().getDecisionLinesEvent().getUsername();
    }
    
    /**
     * Allows setting the password through the Model
     * @param password the password of the user
     */
    public void setPassword(String password) {
    	Model.getModel().getDecisionLinesEvent().setPassword(password);
    }
    
    /**
     * Gets the password of the user from the current DLE
     * @return the password of the user
     */
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
