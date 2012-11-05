package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

abstract public class ExistingEventStatus extends JPanel{
	private static final long serialVersionUID = 1L;

	public ExistingEventStatus(String eventID){

	setBounds(10,45,625,528);
	setLayout(null);	
		
	JLabel Lbl1 = new JLabel("WARNING! Not Implemented!");
	
	Lbl1.setBounds(23,  200, 350, 35);
	add(Lbl1);
	}

}
