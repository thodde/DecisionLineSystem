package model;

import javax.swing.JFrame;

import view.*;
public class Model {
	//public int rounds;
	//public int position;

	//public int nLastXClick;
	//public int nLastYClick;
	private DecisionLinesEvent event;
	
	/* Unnecessary, these are stored under the DecisionLineEvent
	public int nOptionCount;
	public int nOptionEntryCount;
	public int nStep;
	public String[] options;
	public String question;
	public String mode;
	public String type;

	public int[] optionIndices;
	public int[] optionHeights;
    public int nextIndex; 
	public static int Left;
	public static int Right; 
    */
   
    private static Model modelInstance = null;
	
	JFrame j;
    ChoiceListEditor cle;
    
    private Model() {
    	event = null;
    	/*
		nStep = 0;
        nextIndex = 0;
    	optionIndices = new int[100];
    	optionHeights = new int[100];
        
		nOptionCount = 0;
		nOptionEntryCount = 0;
		
		options = null;
		*/
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

    /*
	public DecisionLinesEvent getDecisionLinesEvent() {
		if (event == null)
		return event;
	}
	*/
    
    /*
	public void initOptions(int count) {
		nOptionEntryCount = 0;
		nOptionCount = count;
		options = new String[nOptionCount];
	}

	public boolean addOption(String eventOption) {
		boolean status = false;
		if (nOptionEntryCount < nOptionCount)
		{
			options[nOptionEntryCount] = eventOption;
			nOptionEntryCount++;
			status = true;
		}
		return status;	
	}

	public boolean isClosedEventType(String eventID) {
		boolean f = false;
		
		// replace with server stuff
		if (eventID.contains("ABC1"))
		{
			f = true;
		}
		return f;
	}
	
		
	public void addOptions(String[] eventOptions) {
		nOptionCount = eventOptions.length;
		options = eventOptions;
	}
	*/

    /*
	public void addNewEdge(int optionIndex, int x, int y) {
		nLastXClick = x;
		nLastYClick = y;

		if (nextIndex < 100) {

			optionIndices[nextIndex] = optionIndex;
			optionHeights[nextIndex] = y;
			nextIndex++;
		}
	}
	*/
	/**
	 * This is used for storing and getting the windows;
	 * @author Hang, Wei
	 * @param j
	 */
    //The model should not have a reference to the view
	public void setJFrame(JFrame j){
		this.j = j;
	}
	public JFrame getJFrame(){
		return this.j;
	}
}
