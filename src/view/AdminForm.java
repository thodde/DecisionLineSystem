package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import controller.ButtonController;
import model.Model;

/**
 * Sets up the basic layout of the Administrator form
 * @author Trevor Hodde
 */
public class AdminForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	Model model;
	
	/**
	 * This constructor sets up the entire administrator form
	 * @param m : Model object
	 */
	public AdminForm(Model m) {
		this.model = m;
		
		//set up the form
		setTitle("Draw2Choose Administrative Options");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(625, 575);
		setResizable(false);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = toolkit.getScreenSize();
	    //Following three lines make the form centered
	    int x = (screenSize.width - this.getWidth())/2;
	    int y = (screenSize.height - this.getHeight())/2;
	    this.setLocation(x, y);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//add a tabbed pane so we can view different tabs with different options
		JTabbedPane tabbedAdminPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedAdminPane.setBounds(10, 30, 585, 451);
		add(tabbedAdminPane);

		//set up the manage event tabs
		ManageEventsPanel mep = new ManageEventsPanel(model);
		mep.setLayout(null);
		tabbedAdminPane.addTab("Manage Events", mep);
			
		//set up the generate reports tab
        GenerateReportsPanel grp = new GenerateReportsPanel();
		tabbedAdminPane.addTab("Generate Reports", grp);
		grp.setLayout(null);
				
		//add the exit button
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(259, 492, 89, 23);
		btnExit.addActionListener(new ButtonController(3, this));
		add(btnExit);
	}
}
