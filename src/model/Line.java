package model;

import java.util.ArrayList;

/**
 * This entity maintains information about a single choice in the decision line event
 * @author Martti Peltola
 */
public class Line {

	
	//private Edge edges[]; // you really cannot have a fixed sized array for this.  Instead, try taking advantage of a variable sized array
	private ArrayList<Edge> edges;
	private String choice;
	private int position;
	//private int totalEdgeCount; 
	//private int currentCount;
	private int finalDecision;
	
	/**
	 * This constructor sets up the Line instance
	 * @param n : is this number of edges allowed on line?????
	 * @param choice : text describing the choice associated with this line instance
	 * @param position : ordinal (0th, 1st, 2nd, ..) position of this line instance in the event instance
	 * @author Martti Peltola
	 */
	public Line(String choice, int position) {
		// choice text of line 
		this.choice = choice;
		
		// position of line (0'th, 1st, 2nd, etc.
		this.position = position;
		
		// number of edges we allow on this line ???????????? Am I interpereting his meaning of n correctly?
		//this.totalEdgeCount =  n;
		//currentCount = 0;

		//edges = new Edge[n];
		edges = new ArrayList<Edge>();
	}

	/**
	 * This method returns the choice text
	 * @return : the choice text
	 * @author Martti Peltola
     */
	public String getChoice() {
		return choice;
	}
	
	/**
	 * This method returns the edges on the line
	 * @return : edges on line
	 * @author Martti Peltola
     */
	public ArrayList<Edge> getEdges() {
		return edges;
	}

	/**
	 * This method returns the current number of edges on line
	 * @return : the current number of edges on line
	 * @author Martti Peltola
     */
	public int getCurrentCount() {
		return edges.size();
	}
	
	/**
	 * This method returns the line position
	 * @return : line position
	 * @author Martti Peltola
     */
	public int getLinePosition() {
		return position;
	}
	
	
	/**
	 * This method adds an edge (if valid) on this line
	 * @param e : the new edge proposed for this line
	 * @return : true if we were able to add the edge
	 * @author Martti Peltola
	 */
	public boolean addEdge(Edge e) {
		boolean valid = false;
		if(isValidNewEdge(e)){
			edges.add(e);
			valid = true;
		}
		return valid;
	}

	/**
	 * This method checks to see if a new edge will be valid on this line
	 * @param e : the new edge proposed for this line
	 * @return : true if the edge is valid for this line
	 * @author Martti Peltola
	 */
	public boolean isValidNewEdge(Edge e) {
		boolean valid = true;
		
		for(int i = 0; i < edges.size(); i++) {
			Edge tmpEdge = edges.get(i);
			
			if (tmpEdge.conflictsWith(e)) {
				valid = false;
				break;
			}
		}
		return valid;
	}
	
	/**
	 * Get the final order number of an element
	 * @return the position in the final ordering of a choice
	 */
	public int getFinalOrder() {
		return finalDecision;
	}
	
	/**
	 * Set the position in the final ordering of a choice
	 * @param finalDecision the position in the final ordering of a choice
	 */
	public void setFinalOrder(int finalDecision) {
		this.finalDecision = finalDecision;
	}
}
