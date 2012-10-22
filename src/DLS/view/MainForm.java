package DLS.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.Content;

import DLS.Controller.uiStateController;
import DLS.model.Model;

//================================================================================================
//THIS CLASS IS A SINGLETON!!!!!!
//This class is the primary container for DLS GUI elements
//================================================================================================
//Rev 1  M. Peltola    7-Oct-2012 Class created
//------------------------------------------------------------------------------------------------
//Rev 2  M. Peltola    8-Oct-2012 Add Edge Panel as test of container
//------------------------------------------------------------------------------------------------
//Rev 3  M. Peltola   18-Oct-2012 Cleanup
//------------------------------------------------------------------------------------------------
//Rev 4  M. Peltola   19-Oct-2012 More testing as container
//------------------------------------------------------------------------------------------------
//Rev 5  M. Peltola   20-Oct-2012 Turned into singleton, along with other classes.
//                                Begin to drive content with UI state machine
//================================================================================================
public class MainForm extends JFrame {

	/**
	 * Create the frame.
	 */
	//private JPanel statPanel;
	private StatusPanel  statPanel;
    private JPanel credPanel;

    //===============================================================
    // The following 3 steps turn this class into a singleton
    //===============================================================
    //  1. private & static instance reference to this class
	private static MainForm mainFormInstance = null;

    //===============================================================
    //  2. static factory method
	//  If this is the first time this method is called,
	//  it calls the private constructor and sets it to
	//  the static reference, and returns that reference
	//  Any further calls to this method, returns that reference
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
	static public MainForm getMainForm()
	{
		if(mainFormInstance == null)
		{
			mainFormInstance = new MainForm();
		}

		return mainFormInstance;
	}

    //===============================================================
    //  3. private constructor
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
	private MainForm() {

		// TODO Auto-generated constructor stub
		setTitle("Decision Line Entry4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 682, 575);
		setBounds(25, 25, 700, 675);
	}
	
	//===============================================================
    // clear singleton instance as aid in code testing
	//  Rev 1  -M. Peltola   21-Oct-2012 Method created 
    //===============================================================
    public static void clearMainFormInstance()
    {
    	mainFormInstance = null;
    }

    //===============================================================
    // setup initial form elements and regions
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
	public void SetInitial()
	{

		MainForm.getMainForm().setLayout(null);
		
		addStatusRegion();
		addCredentialsRegion();
		
		uiStateController.getUIStateController().updateUIToNextState(DLS.Controller.uiStateController.AppState.WELCOME);
	}
	
	//===============================================================
    // Add status region to bottom of main container
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
	private void addStatusRegion(){
		
		statPanel = new StatusPanel();
		
		//statPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		//statPanel.setBorder(BorderFactory.createTitledBorder("Status"));
		Rectangle r = getBounds();
		int xb = 25;
		int yb = 25;
		
		
		statPanel.setBounds(xb, r.height-100, r.width-xb, 46);

 	    statPanel.setLayout(null);
		
		MainForm.getMainForm().add(statPanel);
	}

    //===============================================================
    // Add credentials region to top of main container
	// initially hide (not visible on welcome screen)
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
	private void addCredentialsRegion(){

		credPanel = new JPanel();
		//credPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		//edPanel.setBorder(BorderFactory.createTitledBorder("Credentials"));
		
		credPanel.setBounds(25, 5, 639, 55);

		CredentialsPanel cp = new CredentialsPanel();
		credPanel.add(cp);

		// Don't show until later
		credPanel.setVisible(false);

		credPanel.setLayout(null);

		MainForm.getMainForm().add(credPanel);
	}

    //===============================================================
    // Control visibility of credentials region
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
	public void showCredentialsPanel(boolean b)
	{
		credPanel.setVisible(b);
	}
	
    //===============================================================
    // update status 'LED' and status message displayed in status region
	//  Rev 1  -M. Peltola   20-Oct-2012 Method created 
    //===============================================================
	public void updateStatus(boolean status, String statusMsg)
	{
		statPanel.updateStatus(status, statusMsg);
	}
}
