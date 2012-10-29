package DLS.model;

//====================================================================
//THIS CLASS IS A SINGLETON!!!!!!
//This class holds the various information needed by DLS
//--------------------------------------------------------------------
//Rev 1  -M. Peltola   07-Oct-2012 Class created
//--------------------------------------------------------------------
//Rev 2  -M. Peltola   08-Oct-2012 More data added
//--------------------------------------------------------------------
//Rev 3  -M. Peltola   18-Oct-2012 More data added
//--------------------------------------------------------------------
//Rev 4  -M. Peltola   19-Oct-2012 More data added
//--------------------------------------------------------------------
//Rev 5  -M. Peltola   20-Oct-2012 Turned into singleton
//====================================================================
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

    // Basically the UI states displayed by the app
    //public AppState state;
    
    //===============================================================
    // The following 3 steps turn this class into a singleton
    //===============================================================
    //  1. private & static instance reference to this class
    static private Model modelInstance = null; 
    
    //===============================================================
    //  2. static factory method
	//  If this is the first time this method is called,
	//  it calls the private constructor and sets it to
	//  the static reference, and returns that reference
	//  Any further calls to this method, returns that reference
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
    static public Model getModel()
    {
    	if (modelInstance == null)
    	{
    		modelInstance = new Model();
    	}
    	
        return modelInstance;
    }
    
    //===============================================================
    // clear singleton instance as aid in code testing
	//  Rev 1  -M. Peltola   21-Oct-2012 Method created 
    //===============================================================
    public static void clearModelInstance()
    {
        modelInstance = null;
    }
    
    //===============================================================
    //  3. private constructor
	//  Rev 1  -M. Peltola   7-Oct-2012 Method created 
	//  Rev 2  -M. Peltola   20-Oct-2012 Class turned into a singleton 
    //===============================================================
	private Model() {
		nStep = 0;
        nextIndex = 0;
    	optionIndices = new int[100];
    	optionHeights = new int[100];
        
		nOptionCount = 0;
		nOptionEntryCount = 0;
		
		options = null;
		
		//state = AppState.START;

		// get ui state from UI state machine controller singleton.
		//UIStateController uiSC =  UIStateController.getUIStateController();
	}

    //===============================================================
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
		public void initOptions(int count) {
		nOptionEntryCount = 0;
		nOptionCount = count;
		options = new String[nOptionCount];
	}

		//===============================================================
		//  Rev 1  -M. Peltola   20-Oct-2012 Method created
		//===============================================================
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

				//===============================================================
		//  Rev 1  -M. Peltola   28-Oct-2012 Method determines if
		//                                   event is closed
		//                                   NOTE: TEMP rpalce with server operation
		//===============================================================
		public boolean isClosedEventType(String eventID)
		{
			boolean f = false;
			
			// replace with server stuff
			if (eventID.contains("ABC1"))
			{
				f = true;
			}
			return f;
		}
		
		
		//===============================================================
		//  Rev 1  -M. Peltola   20-Oct-2012 Method extracted from older
		//                                   code in constructor and
		//                                   placed into this new method
		//===============================================================
		public void addOptions(String[] eventOptions) {

			nOptionCount = eventOptions.length;
			options = eventOptions.clone();
		}

		//===============================================================
		//  Rev 1  -M. Peltola   7-Oct-2012 Method created
		//===============================================================
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
