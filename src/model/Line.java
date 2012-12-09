package model;

/**
 * This entity maintains information about a single choice in the decision line event
 * @author Martti Peltola
 */
public class Line {

	private Edge edges[]; 
	private String choice;
	private int position;
	private int totalEdgeCount; 
	private int currentCount;
	private int finalDecision;
	
	/**
	 * This constructor sets up the Line instance
	 * @param n : is this number of edges allowed on line?????
	 * @param choice : text describing the choice associated with this line instance
	 * @param position : ordinal (0th, 1st, 2nd, ..) position of this line instance in the event instance
	 * @author Martti Peltola
	 */
	public Line(int n, String choice, int position) {
		// choice text of line 
		this.choice = choice;
		
		// position of line (0'th, 1st, 2nd, etc.
		this.position = position;
		
		// number of edges we allow on this line ???????????? Am I interpereting his meaning of n correctly?
		this.totalEdgeCount =  n;
		currentCount = 0;

		edges = new Edge[n];
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
	public Edge[] getEdges() {
		return edges;
	}

	/**
	 * This method returns the current number of edges on line
	 * @return : the current number of edges on line
	 * @author Martti Peltola
     */
	public int getCurrentCount() {
		return currentCount;
	}
	
	
	/**
	 * This method returns the total number of edges allowed
	 * @return : number of edges allowed
	 * @author Martti Peltola
     */
	public int getTotalEdgeCount() {
		return totalEdgeCount;
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
			edges[currentCount] = e;
			currentCount++;
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
		
		if (currentCount < totalEdgeCount) {
			for(int i = 0; i<currentCount; i++) {
				if (edges[i].conflictsWith(e)) {
					valid = false;
					break;
				}
			}
		}
		else {
			valid = false;
		}
		return valid;
	}
	
	/**
	 * This method returns the next edge after the n'th edge
	 * @param n : ??????
	 * @return : next Edge 
	 * @author Martti Peltola
	 */
	public Edge nextEdge(int n) {
		Edge e = null;
		return e;
	}
	
	public int getFinalOrder() {
		return finalDecision;
	}
	
	public void setFinalOrder(int finalDecision) {
		this.finalDecision = finalDecision;
	}
}
