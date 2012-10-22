package DLS.Controller;

import javax.swing.JPanel;

import DLS.model.Model;
import DLS.view.AdminPanel;
import DLS.view.CreateEvent;
import DLS.view.EdgeDisplayPanel;
import DLS.view.MainForm;
import DLS.view.SimpleEdge;
import DLS.view.WelcomePanel;

//====================================================================
//THIS CLASS IS A SINGLETON!!!!!!
//This class polices the state of the UI
// It tests to see that there really is a change of state, then
// verifies that the transition is an approved transition
// If the state change is valid, the UI is updated to the new state
//Rev 1  -M. Peltola   20-Oct-2012 Class created 
//====================================================================
public class uiStateController {

	public enum AppState
	{
		PENDING_CHANGE,
		START,
		EXIT,
		WELCOME,
		CREATE_EVENT,
		CREATE_CLOSED_EVENT,
		CREATE_OPEN_EVENT,
		ADD_OPEN_EVENT_CHOICE,
		ADD_RR_EDGE,
		ADD_ASYNCH_EDGE,
		FORCE_EVENT_CLOSED,
		VIEW_CHOICES,
		ADMIN,
	}

	// Hang on to this reference, we will want to remove in from the main UI container after we are done with it	
	JPanel welcomePanel;

    //===============================================================
    // The following 3 steps turn this class into a singleton
    //===============================================================
    //  1. private & static instance reference to this class
	static private uiStateController uiSCInstance = null;

    //===============================================================
    //  2. static factory method
	//  If this is the first time this method is called,
	//  it calls the private constructor and sets it to
	//  the static reference, and returns that reference
	//  Any further calls to this method, returns that reference
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
	static public uiStateController getUIStateController()
	{
		if (uiSCInstance == null)
		{
			uiSCInstance = new uiStateController ();
		}

		return uiSCInstance;
	}

    //===============================================================
    //  3. private constructor
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
	private uiStateController ()
	{

	}

    //===============================================================
    // clear singleton instance as aid in code testing
	//  Rev 1  -M. Peltola   21-Oct-2012 Method created 
    //===============================================================
    public static void clearUIStateControllerInstance()
    {
    	uiSCInstance = null;
    }

	
	//====================================================================
	// Method validates UI state change and refreshes UI elements
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
	//====================================================================
	public void updateUIToNextState(AppState nextUIState)
	{
		Model m = Model.getModel();
		
		MainForm mf =MainForm.getMainForm();

		// set the pending state to PENDING_CHANGE, if all is valid,
		// this will be set to the nextState value
		AppState pendingState = AppState.PENDING_CHANGE;

		// first, ensure the new state is really a new state
		if (m.state != nextUIState)
		{
			// ensure that we can transition from the current state to the new state
			switch(nextUIState)
			{
			case WELCOME:
				if (m.state == AppState.START)
				{
					pendingState = nextUIState;
					mf.updateStatus(true, "Welcome");
					
				}
				break;
			case ADD_RR_EDGE:
				if (m.state == AppState.WELCOME)
				{
					pendingState = nextUIState;
					mf.updateStatus(true, "RR Edge");
					mf.showCredentialsPanel(true);
				}
				break;
				
				case CREATE_EVENT:
					if (m.state == AppState.WELCOME)
					{
						pendingState = nextUIState;
						mf.updateStatus(true, "Create Event");
						mf.showCredentialsPanel(true);
					}
					break;
					
				case ADMIN:
					if (m.state == AppState.WELCOME)
					{
						pendingState = nextUIState;
						mf.updateStatus(true, "Admin");
						mf.showCredentialsPanel(true);
					}
					break;					
				
			}

			// if we have a valid new state (not PENDING_CHANGE)
			if (pendingState != AppState.PENDING_CHANGE)
			{
				// update the state in the model
				m.state = pendingState;

				// update the UI
				updateStateComponents();
			}
		}
	}

	//====================================================================
	// Refreshes UI elements based on current UI state
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
	//====================================================================
		private	void updateStateComponents()
	{
		Model m = Model.getModel();
		MainForm mf = MainForm.getMainForm();

		// If this reference exists, we will want to remove from the container now	
		 if(welcomePanel != null)
		 {
			 mf.remove(welcomePanel);
			 welcomePanel = null;
		 }
	
		mf.setVisible(true);

		if (m.state == AppState.WELCOME)
		{
			// Hang on to this reference, we will want to remove in from the main UI container after we are done with it	
			welcomePanel = new WelcomePanel();
			welcomePanel.setBounds(94,137,500,254);

			welcomePanel.setVisible(true);
			mf.add(welcomePanel);
			
			mf.setTitle("Decision Lines");

		}
		else if (m.state == AppState.ADD_RR_EDGE)
		{
			EdgeDisplayPanel p1 = new EdgeDisplayPanel(Model.getModel());
			p1.setVisible(true);
			mf.add(p1);
			mf.setTitle("Decision Lines - Add your edge");
		}
		else if (m.state == AppState.CREATE_EVENT)
		{

			CreateEvent ce = new CreateEvent();
			ce.setVisible(true);
			mf.add(ce);
			mf.setTitle("Decision Lines - Create New Event");
		}
		else if (m.state == AppState.ADMIN)
		{

			AdminPanel admin = new AdminPanel();
			admin.setVisible(true);
			mf.add(admin);
			mf.setTitle("Decision Lines - Administrator Operations");
		}		

		mf.repaint();
	}
}
