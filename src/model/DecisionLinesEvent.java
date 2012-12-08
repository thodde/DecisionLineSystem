package model;

import java.util.ArrayList;

public class DecisionLinesEvent {
	public String question;
	public String mode;
	public String type;
	public int rounds;
	public int position;
	public String eventId;
	public int option;
	public String[] choices;
	public int numChoices;
	public int i;
	public String username;
	public String password;
	private ArrayList<Edge> edges;
	
	public DecisionLinesEvent() {
	     question = "";
	     eventId = "";
	     position = 0;
	     type = "";
	     mode = "";
	     rounds = 0;
	     eventId = "";
	     option = 0;
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
		
	public String getQuestion (){
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
	/*
	public int getOption() {
		return option;
	}
			
	public void setOption(int option) {
		this.option = option;
	}
	*/
	public String getChoice(int i) {
		return choices[i];
	}
	
	public void setChoice (int i, String choice) {
		choices[i] = choice;
	}
	
	public void setCuri(int i) {
		this.i = i;
	}
	
	public int getCuri() {
		return i;
	}
/*
	public boolean setChoice(int position, String choiceText) {
		boolean validChoice = false;

		if (position >= 0 && position < numChoices) {
			if (lines[position] == null) {
				if(!doesChoiceExist(choiceText)) {
					Line newChoice = new Line(0, choiceText, position);
					lines[position] = newChoice;
					validChoice = true;
				}
			}
		}
		return validChoice;
	}
*/

	public boolean isDone() {
		boolean done = false;

		return done;
	}

	public void setNumChoices(int numChoices) {
		this.numChoices = numChoices;
		choices = new String[numChoices];
	}
	
	public int getNumChoices() {
		return numChoices;
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
	
	public void setPassword(String password){
		this.password = password;
	}
}
