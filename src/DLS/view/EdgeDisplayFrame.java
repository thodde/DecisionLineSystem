package DLS.view;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import DLS.Controller.View.AddEdgeController;
import DLS.model.Model;

public class EdgeDisplayFrame extends JFrame{
	

	//====================================================================
	//The constructor does the work of setting up the UI elements
	//which capture a user adding of edges 
	//Rev 1  -M. Peltola   7-Oct-2012 Method created 
	//Rev 2  -M. Peltola   21-Oct-2012 Moved exit button to panel 
	//                                 Made edgeController persist for 
	//                                 life of this panel
	//====================================================================
	public EdgeDisplayFrame(Model m, boolean moderator) {

		setLayout(null);
		setBounds(10,10,770,685);
		
		CredentialsPanel cp = new CredentialsPanel();
		add(cp);
		cp.setVisible(true);

		StatusPanel sp = new StatusPanel();
		sp.setBounds(10, 630, 760, 55);
		add(sp);
		sp.setVisible(true);
		
		EdgeDisplayPanel p = new EdgeDisplayPanel(m, moderator);
		add(p);
		
		p.setVisible(true);
		
	}
	


}
