package DLS.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//====================================================================
//This class provides the GUI elements for the admin state
//Rev 1  -M. Peltola   21-Oct-2012 Class created 
//====================================================================
public class AdminPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	//====================================================================
	//The constructor does the work of setting up the UI elements
	//Rev 1  -M. Peltola   21-Oct-2012 Class created 
	//====================================================================
	public AdminPanel()
	{
		setBounds(10,45,625,528);
		setLayout(null);
		
			JTabbedPane tabbedAdminPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedAdminPane.setBounds(10, 30, 585, 451);
			
			add(tabbedAdminPane);

			// much of the mep code will be relocated to the ManageEventsPanel class 
			ManageEventsPanel mep = new ManageEventsPanel();
			
			//mep.setLayout(new BoxLayout(mep, BoxLayout.Y_AXIS));
			mep.setLayout(null);
			
			tabbedAdminPane.addTab("Manage Events", mep);
			
			// much of the group code will be relocated to the GenerateReportsPanel class 
	        GenerateReportsPanel grp = new GenerateReportsPanel();
			tabbedAdminPane.addTab("Generate Reports", grp);
			grp.setLayout(null);
						
			JButton  btnExit = new JButton("Exit");
			btnExit.setBounds(259, 492, 89, 23);
			add(btnExit);
			
			btnExit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					closeFrame();
				}
	        });
	}
	
	/**
	 * Make sure the user can exit the form if they choose to do so
	 */
	public void closeFrame() {
		JFrame frame = (JFrame) this.getTopLevelAncestor();
		frame.dispose();
	}
}
