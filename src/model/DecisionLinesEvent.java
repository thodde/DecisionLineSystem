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
	public String[] choices;
	public String username;
	public String password;
	private ArrayList<Edge> edges;
	
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
	     edges = null;
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

	public String getChoice(int i) {
		return choices[i];
	}
	
	public void setChoice(int i, String choice) {
		choices[i] = choice;
	}

	public void setNumChoices(int numChoices) {
		choices = new String[numChoices];
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
	 * @return String: the final choice of the event
	 */
	public String determineFinalOrder() {
		return "";
		//TODO: code
	}
	
	/**
	 * This method gets the closest edge to the current position on the line
	 * @param choice int: the choice that we are currently on
	 * @param height: int the height on the decision line
	 * @return int[] the next edge on the line
	 */
	private int[] getNextEdge(int choice, int height) {
		
		//TODO: code
		return null;
	}
}
