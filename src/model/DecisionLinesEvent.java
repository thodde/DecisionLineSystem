package model;

/**
 * This entity maintains information about a decision line event
 * @author Martti Peltola
 */
public class DecisionLinesEvent {

	private int numRounds;
	private int numChoices;
	private boolean closedEvent; 
	private boolean roundRobin;
	private Line[] lines;

	/**
	 * This constructor sets up the basic decison line event
	 * @param numRounds : number of rounds
	 * @param numChoices : number of choices
	 * @param closedEvent : event is closed
	 * @param roundRobinEvent : event is round robin
     * @author Martti Peltola
	 */
	public DecisionLinesEvent(int numRounds, int numChoices, boolean closedEvent, boolean roundRobin) {
		this.numRounds = numRounds;
		this.numChoices = numChoices;
		this.closedEvent = closedEvent; 
		this.roundRobin = roundRobin; 
		
		 lines = new Line[numChoices];
	}

	/**
	 * This method returns the number of rounds
	 * @return : number of rounds
	 * @author Martti Peltola
    */
	public int getNumberOfRounds(){
		return numRounds;
	}

	/**
	 * This method returns the number of choices
	 * @return : number of choices
	 * @author Martti Peltola
     */
	public int getNumberOfChoices(){
		return numChoices;
	}

	/**
	 * This method returns true if the event is closed
	 * @return : true if closed event
	 * @author Martti Peltola
     */
	public boolean isClosedEvent(){
		return closedEvent;
	}

	/**
	 * This method returns true if the event is round robin
	 * @return : true if round robin
	 * @author Martti Peltola
     */
	public boolean isRoundRobinEvent(){
		return roundRobin;
	}

	/**
	 * This method returns a prioritized list of choices
	 * @return : prioritized list of choices
	 * @author Martti Peltola
	 */
	public String[] prioritizedChoices()
	{
		String priChoices[] = null;

		return priChoices;
	}

	/**
	 * This method returns if the edge is valid
	 * @param e : the edge being tested for validiry
     * @return : true if edge is valid
	 * @author Martti Peltola
	 */
	public boolean isValidEdge(Edge e){
		boolean validEdge = true;

		return validEdge;
	}

	/**
	 * This method adds a new edge to the event if the edge is valid
	 * @param e : the new edge being we wish to add to event
	 * @return : true if new edge is valid
	 * @author Martti Peltola
	 */
	public boolean addEdge(Edge e){
		boolean validAdd = true;

		return validAdd;
	}

	/**
	 * This method adds a new edge to the event if the new choice is valid
	 * @return : true if new choice is valid
	 * @author Martti Peltola
	 */
	public boolean setChoice(int position, String choiceText ){
		boolean validChoice = false;

		if (position >= 0 && position < numChoices)
		{
			if (lines[position] == null)
			{

				if(!doesChoiceExist(choiceText)){

					Line newChoice = new Line(0, choiceText, position);

					lines[position] = newChoice;
					validChoice = true;
				}
			}
		}

		return validChoice;
	}
	
	/**
	 * This method searches the event lines for the existence of the choice
	 * @return : true if choice is already present
	 * @author Martti Peltola
	 */
	public boolean doesChoiceExist(String choice)
	{
		boolean exists = false;
		
		for (int i=0; i < numChoices; i++)
		{
			if (lines[i] != null)
			{
				if(lines[i].getChoice().equals(choice))
				{
					exists = true;
					break;
				}
			}
		
		}
		
		return exists;
		
	}

	/**
	 * This method returns if the event is done
	 * @return : true if event is done
	 * @author Martti Peltola
     */
	public boolean isDone(){
		boolean done = false;

		return done;
	}
}
