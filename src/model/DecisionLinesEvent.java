package model;

import java.util.ArrayList;

import view.EdgeDisplayForm;

/**
 * This class stores all the information needed
 * by a Decision Line Event
 * @author Trevor Hodde
 */
public class DecisionLinesEvent {
	public String question;
	public String mode;
	public String type;
	public int rounds;
	public int position;
	public String eventId;
	//public String[] choices;
	private Line[] choices;
	public String username;
	public String password;
	private ArrayList<Edge> edges;
	//private ArrayList<Line> lines;
	static DecisionLinesEvent localInstance = null;
	
	/**
	 * This constructor sets default values to 
	 * all the data used by the Decision Line Event
	 */
	private DecisionLinesEvent() {
	     question = "";
	     eventId = "";
	     position = 0;
	     type = "";
	     mode = "";
	     rounds = 0;
	     eventId = "";
	     username = "";
	     password = "";
	     edges = null;
	 }
	
	public static DecisionLinesEvent getInstance() {
		if (localInstance == null)
			localInstance = new DecisionLinesEvent();
		
		return localInstance;
	}
	
	public ArrayList<Edge> getEdges() {
		if (edges == null)
			edges = new ArrayList<Edge>();
		return edges;
	}

    public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
    
	 public int getRounds() {
		return rounds;
	}
		
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	
	public int getPostion() {
		return position;
	}
			
	public void setPosition(int position) {
		this.position = position;
	}
	
	public String getType() {
		return type;
	}
		
	public void setType(String type) {
		this.type = type;
	}
		
	public String getQuestion() {
		return question;
	}
		
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getEventID() {
		return eventId;
	}
	
	public void setEventID(String eventId) {
		this.eventId = eventId;
	}

	public Line getChoice(int i) {
		if (i < 0 && i >= choices.length)
			return null;
		
		return choices[i];
	}
	
	public void setChoice(Line choice) {
		if (choice.getLinePosition() < 0 && choice.getLinePosition() >= choices.length)
			return;
		
		choices[choice.getLinePosition()] = choice;
		
		if (type.equals("open")) {
			boolean allChoicesSet = true;
			for (int x = 0; x < choices.length; x++) 
				if (choices[x] == null)
					allChoicesSet = false;
			
			if (allChoicesSet) {
				type = "closed";
				
				//if (Model.getModel().getJFrame() != null)
				//	if (Model.getModel().getJFrame() instanceof EdgeDisplayForm)
				//		((EdgeDisplayForm)Model.getModel().getJFrame()).redraw();
			}
		}
	}

	public void setNumChoices(int numChoices) {
		choices = new Line[numChoices];
	}
	
	public int getNumChoices() {
		return choices.length;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * This method will return the final choice of the decision line event
	 */
	public void determineFinalOrder() {
		int preOrder = -1;
		int curOrder = -1;
		int CurandHeight[] = new int[2];
		int curHeight = 0;
		// Calculate each Choice
		for(Line choice : this.choices) {
			preOrder = choice.getLinePosition();
			CurandHeight = this.getNextEdge(preOrder, curHeight);
			curOrder = CurandHeight[0];
			curHeight = CurandHeight[1];
			// Go through the path
			while(curOrder > 0) {
				preOrder = curOrder;
				CurandHeight = this.getNextEdge(preOrder, curHeight);
				curOrder = CurandHeight[0];
				curHeight = CurandHeight[1];
			}
			choice.setFinalOrder(preOrder);
		}
	}

	/**
	 * This method gets the closest edge to the current position on the line
	 * @param choice int: the choice that we are currently on
	 * @param height: int the height on the decision line
	 * @return int[] the next edge on the line
	 */
	private int[] getNextEdge(int choice, int height) {		
		int min = Integer.MAX_VALUE;
		int result[] = new int[2];
		result[0] = -1;
		
		// Go through the each Edge
		for(Edge edge : this.edges) {
			// Check if the Edge is related to the Choice and below the height
			if(edge.getHeight() < height) {
				// Calculate the difference
				int diff = edge.getHeight() - height;
				if(diff < min) {
					if(edge.getLeft() != choice) {
						result[0] = edge.getLeft();
					}
					else {
						result[0] = edge.getRight();
					}
					result[1] = edge.getHeight();
					min = diff;					
				}
			}
		}
		return result;
	}
}
