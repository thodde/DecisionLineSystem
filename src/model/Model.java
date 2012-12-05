package model;

import javax.swing.JFrame;

import view.*;
public class Model {
	public int nOptionCount;
	public int nOptionEntryCount;
	public int nStep;
	public String[] options;
	public String question;
	public String mode;
	public String type;
	public int rounds;
	public int position;
	public boolean isModerator;

	public int nLastXClick;
	public int nLastYClick;
	
	public int[] optionIndices;
	public int[] optionHeights;
    public int nextIndex; 
   
    private static Model modelInstance = null;
	public static int Left;
	public static int Right; 
	
	JFrame j;
    ChoiceListEditor cle;
    
    private Model() {
		nStep = 0;
        nextIndex = 0;
    	optionIndices = new int[100];
    	optionHeights = new int[100];
        
		nOptionCount = 0;
		nOptionEntryCount = 0;
		
		options = null;
		isModerator = false;
	}
    
    public static Model getModel() {
    	if (modelInstance == null)
    	{
    		modelInstance = new Model();
    	}
    	
        return modelInstance;
    }
    
    public static DecisionLinesEvent getEvent() {
    	return DecisionLinesEvent.getInstance();
    }
    
    /**
     * make the DecisionLinesEvent to be inner class in the model
     * @author Hang, Wei
     */
    public void setDecisionLinesEvent (DecisionLinesEvent event) {
		event = DecisionLinesEvent.getInstance();
	}

	public DecisionLinesEvent getDecisionLinesEvent() {
		return DecisionLinesEvent.getInstance();
	}
    
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

	public void addNewEdge(int optionIndex, int x, int y) {
		nLastXClick = x;
		nLastYClick = y;

		if (nextIndex < 100) {

			optionIndices[nextIndex] = optionIndex;
			optionHeights[nextIndex] = y;
			nextIndex++;
		}
	}
	/**
	 * This is used for storing and getting the windows;
	 * @author Hang, Wei
	 * @param j
	 */
	public void setJFrame(JFrame j){
		this.j = j;
	}
	public JFrame getJFrame(){
		return this.j;
	}
}
