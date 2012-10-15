package SimpleEdge.model;

public class Model {
	public int nOptionCount;
	public int nStep;
	final public String[] options;

	public int nLastXClick;
	public int nLastYClick;
	
	public int[] optionIndices;
	public int[] optionHeights;
    public int nextIndex; 
	
	public Model(String[] eventOptions) {
		nStep = 0;
        nextIndex = 0;
    	optionIndices = new int[100];
    	optionHeights = new int[100];
        
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
