package model;

/**
 * This DesicisionLinesEvent entity has many attributes and method. 
 * It is used to store the information we need about the Decision Line Event
 * @author Hang, Wei
 */
public class DecisionLinesEvent {

	public String question;
	public String mode;
	public String type;
	public int rounds;
	public int position;
	public String eventId;
	public int option;
	public String choices[];
	public int i;
	public static DecisionLinesEvent instance;
	
	private DecisionLinesEvent() {
	     question = "";
	     eventId = "";
	     position = 0;
	     type = "";
	     mode = "";
	     rounds = 0;
	     eventId = "";
	     option = 0;
	     choices = new String[option];
	     instance = null;
	 }
	
	public static DecisionLinesEvent getInstance() {
		if (instance == null) {
			instance = new DecisionLinesEvent();
		}
		return instance;
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
	
	public int getOption() {
		return option;
	}
			
	public void setOption(int option) {
		this.option = option;
	}
	
	public String getChoice(int i) {
		return choices[i];
	}
	
	public void setChoice (int i, String choice) {
		choices[i] = choice;
		setCuri(i);
	}
	public void setCuri(int i) {
		this.i = i;
	}
	
	public int getCuri(){
		return i;
	}
/*
	public boolean setChoice(int position, String choiceText ) {
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

	public boolean doesChoiceExist(String choice) {
		boolean exists = false;
		
		for (int i=0; i < numChoices; i++) {
			if (lines[i] != null) {
				if(lines[i].getChoice().equals(choice)) {
					exists = true;
					break;
				}
			}
		}
		return exists;
	}
*/

	public boolean isDone(){
		boolean done = false;

		return done;
	}
}
