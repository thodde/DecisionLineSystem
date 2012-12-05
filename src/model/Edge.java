package model;

/**
 * This entity maintains information about a single edge in the decision line event
 * @author Martti Peltola
 */
public class Edge {
	private int left;
	private int right;
	private int height;
	
	// no edge can be vertically closer than this value to another edge
	final int conflictLimit = 7;
	
	/**
	 * This constructor sets up the Edge instance
	 * @param left : position of left line edge lies on
	 * @param right : position of right line edge lies on
	 * @param height : height of edge
	 * @author Martti Peltola
	 */
	public Edge (int left, int right, int height) {
		// pre conditions we must pass
		if (left+1 != right) {
	    }
		
		if (height<0) {
			
		}
			
		this.right = right;
		this.left = left;
		this.height = height;
	}

	/**
	 * This method returns the left index
     * @return : the left index
	 * @author Martti Peltola
	 */
	public int getLeft(){return left;}

	/**
	 * This method returns the right index
     * @return : the right index
	 * @author Martti Peltola
	 */
	public int getRight(){return right;}

	/**
	 * This method returns the edge height
     * @return : the edge height
	 * @author Martti Peltola
	 */
	public int getHeight(){return height;}

	/**
	 * This method determines if this edge and the other edge conflict
	 * @param e : the other edge being tested against this edge
	 * @return : true if the 2 edges are in conflict
	 * @author Martti Peltola
	 */
	boolean conflictsWith(Edge e) {
		boolean conflicts = false;
		
		if (right == e.getRight() && left == e.getLeft() && Math.abs(height- e.getHeight()) <= conflictLimit ) {
			conflicts = true;
		}
		
		return conflicts;
	}

}
