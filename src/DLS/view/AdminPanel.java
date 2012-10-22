package DLS.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//====================================================================
//This class provides the GUI elements for the admin state
//Rev 1  -M. Peltola   21-Oct-2012 Class created 
//====================================================================
public class AdminPanel extends JPanel{
	
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
			
			JPanel rbContainer = new JPanel();
			
			rbContainer.setBounds(40,10,530,242);
			
			mep.add(rbContainer);
			rbContainer.setLayout(null);
			
			int y = 10;
			int rbh = 40;
			
			JPanel rb1Panel = new JPanel();
			rb1Panel.setBounds(0, y+rbh*0, 495, rbh);
			rbContainer.add(rb1Panel);
			rb1Panel.setLayout(null);
			//rb1Panel.setBounds(10, 23, 329,30);
			rb1Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			
			JRadioButton rb1 = new JRadioButton("1");
			rb1.setBounds(23, 5, 21, 21);
			//radioButton1.setBounds(67, 5, 21, 21);
			rb1Panel.add(rb1);
			
			JLabel rb1LblA = new JLabel("Remove all completed events more than ");
			rb1LblA.setBounds(56, 8, 240, 14);
			rb1Panel.add(rb1LblA);
			
			JTextField rb1Txt = new JTextField();
			rb1Txt.setBounds(295, 5, 28, 20);
	        rb1Panel.add(rb1Txt);
				
				
			JLabel rb1LblB = new JLabel(" days old ");
			rb1LblB.setBounds(333, 8, 82, 14);
	        rb1Panel.add(rb1LblB);

			JPanel rb2Panel = new JPanel();
			rb2Panel.setBounds(0, y+rbh*1, 495, rbh);
			rbContainer.add(rb2Panel);
			rb2Panel.setLayout(null);
			//rb2Panel.setBounds(10, 50, 329,30);
			rb2Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

			JRadioButton rb2 = new JRadioButton("2");
			rb2.setBounds(23, 5, 21, 21);
			//radioButton1.setBounds(67, 5, 21, 21);
			rb2Panel.add(rb2);

			
			JLabel rb2LblA = new JLabel("Remove all uncompleted events more than ");
			rb2LblA.setBounds(56, 8, 246, 14);
			rb2Panel.add(rb2LblA);
			
			JTextField rb2Txt = new JTextField();
			rb2Txt.setBounds(314, 5, 28, 20);
	        rb2Panel.add(rb2Txt);
				
				
			JLabel rb2LblB = new JLabel(" days old ");
			rb2LblB.setBounds(355, 8, 78, 14);
	        rb2Panel.add(rb2LblB);
			
			
			JPanel rb3Panel = new JPanel();
			rb3Panel.setBounds(0, 90, 520, 40);
			rbContainer.add(rb3Panel);
			rb3Panel.setLayout(null);
			//rb2Panel.setBounds(10, 50, 329,30);
			rb3Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

			
			JRadioButton rb3 = new JRadioButton("2");
			rb3.setBounds(23, 5, 21, 21);
			//radioButton1.setBounds(67, 5, 21, 21);
			rb3Panel.add(rb3);

			
			JLabel rb3LblA = new JLabel("Force early completion of all uncompleted events more than ");
			rb3LblA.setBounds(56, 8, 356, 14);
			rb3Panel.add(rb3LblA);
			
			JTextField rb3Txt = new JTextField();
			rb3Txt.setBounds(410, 5, 28, 20);
	        rb3Panel.add(rb3Txt);
				
				
			JLabel rb3LblB = new JLabel(" days old ");
			rb3LblB.setBounds(439, 8, 71, 14);
	        rb3Panel.add(rb3LblB);
	
			
			JPanel rb4Panel = new JPanel();
			rb4Panel.setBounds(0, y+rbh*3, 495, rbh);
			rbContainer.add(rb4Panel);
			rb4Panel.setLayout(null);
			//rb2Panel.setBounds(10, 50, 329,30);
			rb3Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			
			JRadioButton rb4 = new JRadioButton("2");
			rb4.setBounds(23, 5, 21, 21);
			//radioButton1.setBounds(67, 5, 21, 21);
			rb4Panel.add(rb4);

			
			JLabel rb4LblA = new JLabel("Force early completion of event ");
			rb4LblA.setBounds(56, 8, 188, 14);
			rb4Panel.add(rb4LblA);
			
			JTextField rb4Txt = new JTextField();
			rb4Txt.setBounds(254, 5, 92, 20);
	        rb4Panel.add(rb4Txt);
				
	
			JPanel rb5Panel = new JPanel();
			rb5Panel.setBounds(0, y+rbh*4, 495, rbh);
			rbContainer.add(rb5Panel);
			rb5Panel.setLayout(null);
			//rb2Panel.setBounds(10, 50, 329,30);
			rb5Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			
			
			JRadioButton rb5 = new JRadioButton("2");
			rb5.setBounds(23, 5, 21, 21);
			//radioButton1.setBounds(67, 5, 21, 21);
			rb5Panel.add(rb5);

			
			JLabel rb5LblA = new JLabel("Remove event ");
			rb5LblA.setBounds(56, 8, 95, 14);
			rb5Panel.add(rb5LblA);
			
			JTextField rb5Txt = new JTextField();
			rb5Txt.setBounds(161, 5, 95, 20);
	        rb5Panel.add(rb5Txt);
							
			
			JButton btnPerformRequestedOperations = new JButton("Perform requested Operations");
			btnPerformRequestedOperations.setBounds(180, 322, 205, 23);
			mep.add(btnPerformRequestedOperations);
	
			
			// much of the group code will be relocated to the GenerateReportsPanel class 
	        GenerateReportsPanel grp = new GenerateReportsPanel();
			tabbedAdminPane.addTab("Generate Reports", grp);
			grp.setLayout(null);
			add(tabbedAdminPane);
			
			JButton btnGenerateRequestedReports = new JButton("Generate requested reports");
			btnGenerateRequestedReports.setBounds(180, 322, 205, 23);
			grp.add(btnGenerateRequestedReports);
						
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
