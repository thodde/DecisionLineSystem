package DLS.Controller.View;

import DLS.view.AdminPanel;
import DLS.view.MainForm;


//====================================================================
//This class provides the controller operation to setup 
// the GUI elements for admin operations
//Rev 1  -M. Peltola   27-Oct-2012 Class created 
//====================================================================
public class WelcomeAdministratorController {
	
	//====================================================================
	//The constructor for the controller which sets up
	//  the GUI elements for admin operations
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================	
	public WelcomeAdministratorController(){
		
	}
	
	//====================================================================
	//The controller's invoking method which sets up
	//  the GUI elements for admin operations
	//Rev 1  -M. Peltola   27-Oct-2012 Class created 
	//====================================================================	
	public void setupAdminGUI(){
		
		MainForm mf = MainForm.getMainForm();

		mf.showCredentialsPanel(true);
		AdminPanel admin = new AdminPanel();
		admin.setVisible(true);
		mf.add(admin);
		mf.setTitle("Decision Lines - Administrator Operations");
	}
	

}
