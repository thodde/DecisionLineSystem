package view;

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
	
	public AdminForm(Model m)
	{
		this.model = m;
		
		setTitle("Draw2Choose Administrative Options");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(625, 575);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedAdminPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedAdminPane.setBounds(10, 30, 585, 451);
		add(tabbedAdminPane);

		ManageEventsPanel mep = new ManageEventsPanel(model);
		mep.setLayout(null);
		tabbedAdminPane.addTab("Manage Events", mep);
			
        GenerateReportsPanel grp = new GenerateReportsPanel();
		tabbedAdminPane.addTab("Generate Reports", grp);
		grp.setLayout(null);
						
		JButton  btnExit = new JButton("Exit");
		btnExit.setBounds(259, 492, 89, 23);
		btnExit.addActionListener(new ButtonController(model, 3, this));
		add(btnExit);
	}
}
