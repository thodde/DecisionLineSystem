package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This class provides the GUI elements for the admin Generate Reports tab
 * @author Martti Peltola
 */
public class GenerateReportsPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * The constructor does the work of setting up the UI elements
	 * when they start a session with DLS 
	 */
	public GenerateReportsPanel(){
		int y = 10;
		int rbh = 40;
		int i =0;
		setLayout(null);
		
		int x = 23;
		int w = 540;
		int w2 = 60;
		
		JLabel fl1 = new JLabel("Path: ");
		fl1.setBounds(x, y+rbh*i, w2, 23);
		add(fl1);
	
		JTextField txtf1 = new JTextField("c:\\rpt.txt");
		txtf1.setBounds(w2, y+rbh*i, w2+250, 23);
		add(txtf1);
		
		i++;
		y += 10;
		
		JRadioButton rb1 = new JRadioButton("Generate report of all uncompleted decision events");
		buttonGroup.add(rb1);
		rb1.setBounds(x, y+rbh*i++, w, 23);
		add(rb1);
		rb1.setSelected(true);
		
		JRadioButton rb2 = new JRadioButton("Generate report of all completed events");
		buttonGroup.add(rb2);
		rb2.setBounds(x, y+rbh*i++, w, 23);
		add(rb2);
		
		JRadioButton rb3 = new JRadioButton("Generate report of all system statistics");
		buttonGroup.add(rb3);
		rb3.setBounds(x, y+rbh*i++, w, 23);
		add(rb3);

		JRadioButton rb4 = new JRadioButton("Generate report of system error log");
		buttonGroup.add(rb4);
		rb4.setBounds(x, y+rbh*i++, w, 23);
		add(rb4);

		JButton btnGenerateRequestedReports = new JButton("Generate requested reports");
		btnGenerateRequestedReports.setBounds(180, 322, 205, 23);
		add(btnGenerateRequestedReports);
	}
}
