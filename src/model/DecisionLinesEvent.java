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
	public DecisionLinesEvent() {
	     question = "";
	     eventId = "";
	     position = 0;
	     type = "";
	     mode = "";
	     rounds = 0;
	     eventId = "";
	     username = "";
	     password = "";
	     edges = new ArrayList<Edge>();
	 }
	
	/**
	 * Sets the DecisionLinesEvent object as a singleton
	 * @return The current DecisionLinesEvent object
	 */
	public static DecisionLinesEvent getInstance() {
		if (localInstance == null)
			localInstance = new DecisionLinesEvent();
		
		return localInstance;
	}
	
	/**
	 * Gets an arraylist of all the edges in an event
	 * @return arraylist of edges
	 */
	public ArrayList<Edge> getEdges() {
		if (edges == null)
			edges = new ArrayList<Edge>();
		return edges;
	}

	/**
	 * Get the mode of game play for the event (round robin or asynch)
	 * @return Either roundRobin or asynchronous
	 */
    public String getMode() {
		return mode;
	}
	
    /**
     * Set the mode of game play
     * @param mode Either roundRobin or asynchronous
     */
	public void setMode(String mode) {
		this.mode = mode;
	}
    
	/**
	 * Get the number of rounds in an event
	 * @return the number of rounds
	 */
	 public int getRounds() {
		return rounds;
	}
	 
	/**
	 * Set the number of rounds in an event	
	 * @param rounds the number of rounds in the event
	 */
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	
	/**
	 * Get the position of a choice in the decision order
	 * @return the position of a choice
	 */
	public int getPostion() {
		return position;
	}
			
	/**
	 * Set the position of a choice in the decision order
	 * @param position the position of a choice
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * Get the type of the event (open or closed)
	 * @return Either open or closed depeneding on type of event
	 */
	public String getType() {
		return type;
	}
		
	/**
	 * Set the type of event
	 * @param type Either open or closed
	 */
	public void setType(String type) {
		this.type = type;
	}
		
	/**
	 * Gets the question for the event
	 * @return the question for the event
	 */
	public String getQuestion() {
		return question;
	}
		
	/**
	 * Set the question for the event
	 * @param question the question for the event
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Get the ID of the current DecisionLinesEvent
	 * @return the ID of the event
	 */
	public String getEventID() {
		return eventId;
	}
	
	/**
	 * Set the ID of the event
	 * @param eventId the ID of the event
	 */
	public void setEventID(String eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets a specific choice in the list of Lines
	 * @param i The line to retrieve
	 * @return The choice at the specified index
	 */
	public Line getChoice(int i) {
		if (i < 0 && i >= choices.length)
			return null;
		
		return choices[i];
	}
	
	/**
	 * Set the choice at a particular index
	 * @param choice The line to set
	 */
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

	/**
	 * Set the number of choices for the event
	 * @param numChoices the number of choices
	 */
	public void setNumChoices(int numChoices) {
		choices = new Line[numChoices];
	}
	
	/**
	 * Get the number of choices for the event
	 * @return the number of choices
	 */
	public int getNumChoices() {
		return choices.length;
	}
	
	/**
	 * Get the name of the user
	 * @return the name of the user
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Set the name of the current user
	 * @param username The name of the user
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get the password of the current user
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set the password of the current user
	 * @param password the password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
     * This method sets the final order for each choice in the decision line event
     */
    public void determineFinalOrder() {
        //make an array to store the current edge in one spot and its height in the other
        int heights[] = new int[2];
        //make sure we start at the top
        int currentHeight = 0; 
        int currentPosition = 0;
        
        // Calculate each Choice
        for(int i = 0; i < choices.length; i++) {
            currentPosition = choices[i].getLinePosition();
            currentHeight = 65000;

            while(currentHeight > 0) {
                    heights = getNextEdge(currentPosition, currentHeight);
                    currentPosition = heights[0];
                    currentHeight = heights[1];
            }
            choices[i].setFinalOrder(currentPosition);
        }
    }

    /**
     * This method gets the closest edge to the current position on the line
     * @param choice int: the choice that we are currently on
     * @param height: int the height on the decision line
     * @return int[] the next edge on the line
     */
    private int[] getNextEdge(int choice, int height) {  
        if (edges == null) 
            return new int[] { choice, 0 };
        
        Edge currentEdge;
        int results[] = new int[] { choice, 0 };
        int currentHeight = 0;
        
        // Go through the each Edge on the lines
        for(int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            //make sure the next edge is below the current height
            if((currentEdge.getHeight() > currentHeight) && (currentEdge.getHeight() < height) && 
                    (currentEdge.getLeft() == choice || currentEdge.getRight() == choice)) {
                //we are already on the right, we have to move left
                if(choice != currentEdge.getLeft()) {
                        results[0] = currentEdge.getLeft();
                }
                else { //if we are already on the left, we have to go right
                        results[0] = currentEdge.getRight();
                }
                //store the height of the current edge
                results[1] = currentEdge.getHeight();
                currentHeight = results[1];
            }
        }
        return results;
    }
	
	/**
	 * This method allows us to get the final ordering at the end of the event
	 * and display it for all users
	 * @param position int the position in the ordering of the current choice
	 * @return String the name of the choice at the current position
	 */
	public String getChoiceOrderPosition(int position) {
		String choiceName = "";
		for(int i = 0; i < choices.length; i++) {
			if(choices[i].getFinalOrder() == position) {
				choiceName = choices[i].getChoice();
			}
		}
		return choiceName;
	}
}
