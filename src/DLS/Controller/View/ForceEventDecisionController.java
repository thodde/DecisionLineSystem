package DLS.Controller.View;

public class ForceEventDecisionController {
	
	String eventID;
	
	public ForceEventDecisionController(String eventID) 
	{
		this.eventID= eventID;
	}
	public boolean forceEvent()
	{
		boolean stat = true;
		// send request to server to force this event closed
		return stat;
	}

}
