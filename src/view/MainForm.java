package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ButtonController;
import model.Model;

/**
 * This class sets up the main form which is in charge
 * of delegating the work for the rest of the application.
 * This can be considered the start of the Chain of Responsibility
 * design pattern.
 * @author Trevor Hodde
 */
public class MainForm extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	Model model;
	JButton[] buttons;
	JLabel titleLabel;
	JLabel lblNewLabel;
	JTextField txtEventId;

	/**
	 * This constructor sets up the start up form for the application.
	 * The user can enter their event ID, or select administrative options
	 * from this form.
	 * @param Model m : A reference to the model
	 */
	public MainForm(Model m) {
		this.model = m;
		setTitle("Draw 2 Choose");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 350);
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

		//sets the proper labels for the form
		titleLabel = new JLabel("Welcome to Draw2Choose - Please choose your role");
		titleLabel.setBounds(175, 30, 400, 25);
		this.add(titleLabel);

		lblNewLabel = new JLabel("Enter your EventID");
		lblNewLabel.setBounds(260, 120, 150, 25);
		this.add(lblNewLabel);

		//creates the event ID text box
		txtEventId = new JTextField();
		txtEventId.setBounds(180, 150, 300, 25);
		this.add(txtEventId);

		//sets up all the buttons on the main form and gives a reference to their controllers
		buttons = new JButton[4];
		buttons[0] = new JButton("Moderator");
		buttons[0].setBounds(110, 250, 90, 25);
		buttons[0].addActionListener(new ButtonController(0, this));
		contentPane.add(buttons[0]);
		buttons[1] = new JButton("User");
		buttons[1].setBounds(110*2, 250, 90, 25);
		buttons[1].addActionListener(new ButtonController(1, this));
		contentPane.add(buttons[1]);
		buttons[2] = new JButton("Administrator");
		buttons[2].setBounds(110*3, 250, 90, 25);
		buttons[2].addActionListener(new ButtonController(2, this));
		contentPane.add(buttons[2]);
		buttons[3] = new JButton("Exit");
		buttons[3].setBounds(110*4, 250, 90, 25);
		buttons[3].addActionListener(new ButtonController(3, this));
		contentPane.add(buttons[3]);

		//set focus to the moderator button for easy navigation
		getRootPane().setDefaultButton(buttons[0]);
    }

	/** To redraw the frame we repaint the internal boxes. */
	public void redraw() {
		this.repaint();
	}

	/**
	 * Gets a reference to the text box for event IDs
	 * @return String eventID
	 */
	public String getTextField () {
		return txtEventId.getText();
	}

	/**
	 * Sets the value of the event ID text box
	 * @param s String eventID
	 */
	public void setTextField(String s) {
		txtEventId.setText(s);
	}
}