package model;

public class Model {
	public int nOptionCount;
	public int nOptionEntryCount;
	public int nStep;
	public String[] options;

	public int nLastXClick;
	public int nLastYClick;
	
	public int[] optionIndices;
	public int[] optionHeights;
    public int nextIndex; 

    static private Model modelInstance = null; 
    
    public Model() {
		nStep = 0;
        nextIndex = 0;
    	optionIndices = new int[100];
    	optionHeights = new int[100];
        
		nOptionCount = 0;
		nOptionEntryCount = 0;
		
		options = null;
	}
    
    static public Model getModel()
    {
    	if (modelInstance == null)
    	{
    		modelInstance = new Model();
    	}
    	
        return modelInstance;
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
		options = eventOptions.clone();
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
}
