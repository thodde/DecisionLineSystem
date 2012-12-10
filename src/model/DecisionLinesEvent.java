package model;

import java.util.ArrayList;

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
	private Line[] choices;
	public String username;
	public String password;
	private ArrayList<Edge> edges;
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
	 * This method sets the final choice of the decision line event
	 */
	public void determineFinalOrder() {
		//grab the first choice in the choice list
		Line currentChoice = this.choices[0];
		//make an array to store the current edge in one spot and its height in the other
		int heights[] = new int[2];
		//make sure we start at the top
		int currentHeight = 0; 
		int position;
		int currentPosition;
		
		// Calculate each Choice
		for(int i = 0; i < this.choices.length; i++) {
			position = currentChoice.getLinePosition();
			heights = getNextEdge(position, currentHeight);
			currentPosition = heights[0];
			currentHeight = heights[1];
			// Go through the path
			while(currentPosition > 0) {
				position = currentPosition;
				heights = getNextEdge(position, currentHeight);
				currentPosition = heights[0];
				currentHeight = heights[1];
			}
			currentChoice.setFinalOrder(position);
			System.out.println("choice " + currentChoice.getChoice() + " " + currentChoice.getFinalOrder());
		}
	}

	/**
	 * This method gets the closest edge to the current position on the line
	 * @param choice int: the choice that we are currently on
	 * @param height: int the height on the decision line
	 * @return int[] the next edge on the line
	 */
	private int[] getNextEdge(int choice, int height) {	
		//grab the first edge
		Edge currentEdge = this.edges.get(0);
		int results[] = new int[2];
		
		// Go through the each Edge on the lines
		for(int i = 0; i < this.edges.size(); i++) {
			//make sure the next edge is below the current height
			if(currentEdge.getHeight() > height) {
				//we are already on the right, we have to move left
				if(choice == currentEdge.getRight()) {
					results[0] = currentEdge.getLeft();
				}
				else { //if we are already on the left, we have to go right
					results[0] = currentEdge.getRight();
				}
				//store the height of the current edge
				results[1] = currentEdge.getHeight();
			}
		}
		return results;
	}
}
