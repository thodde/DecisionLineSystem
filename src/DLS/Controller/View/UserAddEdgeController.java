package DLS.Controller.View;

import DLS.model.Model;
import DLS.view.EdgeDisplayPanel;
import DLS.view.MainForm;

//====================================================================
//This class provides the controller which sets up the GUI elements 
//for the add edge panel
//Rev 1  -M. Peltola   28-Oct-2012 Class created 
//====================================================================	
public class UserAddEdgeController {
	
	//====================================================================
	//The constructor for the controller which sets up the add edge
	// panel 
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
	public UserAddEdgeController(){
		
	}
	
	//====================================================================
	//This is the controller's invoking methods  which sets up the add edge
	// panel 
	//Rev 1  -M. Peltola   26-Oct-2012 Class created 
	//====================================================================
		public void setupAddEdgeGUI(String eventID, boolean moderator)
	{
		MainForm mf = MainForm.getMainForm();
		
		mf.updateStatus(true, "RR Edge");
		mf.showCredentialsPanel(true);
		
		EdgeDisplayPanel p1 = new EdgeDisplayPanel(Model.getModel(), moderator);
		p1.setVisible(true);
		mf.add(p1);
		mf.setTitle("Decision Lines - Add your edge");		
	}

}
