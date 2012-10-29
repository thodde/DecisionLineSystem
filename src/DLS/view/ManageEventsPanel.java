package DLS.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//====================================================================
//This class provides the GUI elements for the admin
//Manage events tab
//NOTE: The code is still in the admin panel class and will be
//relocated here in the near future -MAP
//Rev 1  -M. Peltola   21-Oct-2012 Class created 
//====================================================================
public class ManageEventsPanel extends JPanel{
	
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
	//====================================================================
	//The constructor does the work of setting up the UI elements
	//when they start a session with DLS 
	//NOTE: The code is still in the admin panel class and will be
	//relocated here in the near future -MAP
	//--------------------------------------------------------------------
	//Rev 1  -M. Peltola   21-Oct-2012 Method created 
	//Rev 2  -M. Peltola   24-Oct-2012 Moved gManage Events UI element code from admin panel to here 
	//====================================================================
	public ManageEventsPanel() {
	
		int y = 10;
		int rbh = 40;
		int i =0;
		
		JPanel rb1Panel = new JPanel();
		rb1Panel.setBounds(0, y+rbh*i++, 495, rbh);
		add(rb1Panel);
		rb1Panel.setLayout(null);
		rb1Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		
		JRadioButton rb1 = new JRadioButton("1");
		buttonGroup.add(rb1);
		rb1.setBounds(23, 5, 21, 21);
		rb1Panel.add(rb1);
		rb1.setSelected(true);

		
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
		rb2Panel.setBounds(0, y+rbh*i++, 495, rbh);
		add(rb2Panel);
		rb2Panel.setLayout(null);
		rb2Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		JRadioButton rb2 = new JRadioButton("2");
		buttonGroup.add(rb2);
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
		rb3Panel.setBounds(0, y+rbh*i++, 520, 40);
		add(rb3Panel);
		rb3Panel.setLayout(null);
	    rb3Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		
		JRadioButton rb3 = new JRadioButton("3");
		buttonGroup.add(rb3);
		rb3.setBounds(23, 5, 21, 21);
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
		rb4Panel.setBounds(0, y+rbh*i++, 495, rbh);
		add(rb4Panel);
		rb4Panel.setLayout(null);
		rb3Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		
		JRadioButton rb4 = new JRadioButton("4");
		buttonGroup.add(rb4);
		rb4.setBounds(23, 5, 21, 21);
		rb4Panel.add(rb4);

		
		JLabel rb4LblA = new JLabel("Force early completion of event ");
		rb4LblA.setBounds(56, 8, 188, 14);
		rb4Panel.add(rb4LblA);
		
		JTextField rb4Txt = new JTextField();
		rb4Txt.setBounds(254, 5, 92, 20);
        rb4Panel.add(rb4Txt);
			

		JPanel rb5Panel = new JPanel();
		rb5Panel.setBounds(0, y+rbh*i++, 495, rbh);
		add(rb5Panel);
		rb5Panel.setLayout(null);
		rb5Panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		
		
		JRadioButton rb5 = new JRadioButton("5");
		buttonGroup.add(rb5);
		rb5.setBounds(23, 5, 21, 21);
		rb5Panel.add(rb5);

		
		JLabel rb5LblA = new JLabel("Remove event ");
		rb5LblA.setBounds(56, 8, 95, 14);
		rb5Panel.add(rb5LblA);
		
		JTextField rb5Txt = new JTextField();
		rb5Txt.setBounds(161, 5, 95, 20);
        rb5Panel.add(rb5Txt);
						
		
		JButton btnPerformRequestedOperations = new JButton("Perform requested Operations");
		btnPerformRequestedOperations.setBounds(180, 322, 221, 23);
		add(btnPerformRequestedOperations);
	}

}
