package DLS.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

//====================================================================
//This class adds the GUI for managing an existing event 
// placekeeper, not implemented
//Rev 1  -M. Peltola   28-Oct-2012 Class created 
//====================================================================	
public class ExistingEventStatus extends JPanel{
	
	public ExistingEventStatus(String eventID){

	setBounds(10,45,625,528);
	setLayout(null);	
		
	JLabel Lbl1 = new JLabel("WARNING! Not Implemented!");
	
	Lbl1.setBounds(23,  200, 350, 35);
	add(Lbl1);
	}

}
