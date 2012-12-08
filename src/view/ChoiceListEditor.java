package view;

import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AddChoiceController;
import model.DecisionLinesEvent;
import model.Model;

/**
 * This class allows the moderator to enter and remove
 * choices for the current decision lines event
 * @author Trevor Hodde
 */
public class ChoiceListEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	Model model;
	final int AllItems = -1;
	List itemList;
	public String currentItem;
	JTextField txtEditField;
	JButton btnSubmit;
	JButton btnAddChoice;
	JButton btnRemoveChoice;
	final int maxChoices;
	int numChoices;
	String choice;
	private DecisionLinesEvent event;
	String type;
	
	/**
	 * This constructor sets up the GUI for the list editor
	 */
	public ChoiceListEditor() {
		this.model = Model.getModel();
		event = model.getDecisionLinesEvent();
		type = event.getType();
		
		if (type.equals("closed") && event.position == 0)
			this.maxChoices = event.getNumChoices();
		else
			this.maxChoices = 1;
		this.numChoices = 0;
		
		setTitle("Event Choices");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(600, 450);
		
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

		//This is the list that holds all of the values
		itemList = new List(10, false);
	    itemList.setBounds(50, 10, 430, 280);
		contentPane.add(itemList);

		//text box for entering new choices
		txtEditField = new JTextField();
		txtEditField.setBounds(50, 300, 200, 25);
		txtEditField.setColumns(10);
		contentPane.add(txtEditField);
		
		//submit button to allow the moderator to complete their list
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(250, 350, 100, 25);
		btnSubmit.setVisible(true);
		btnSubmit.setEnabled(false);
		contentPane.add(btnSubmit);
		
		//add a listener to the button to load up the credentials form when it is pushed
		btnSubmit.addActionListener(new AddChoiceController(this));
		
		//allows the moderator to remove a choice
		btnRemoveChoice = new JButton("Remove Item");
		btnRemoveChoice.setBounds(380, 300, 100, 25);
		btnRemoveChoice.setVisible(true);
		
		//allows the moderator to add a choice
		btnAddChoice = new JButton("Add Item");
		btnAddChoice.setBounds(265, 300, 100, 25);
		btnAddChoice.setVisible(true);
		contentPane.add(btnAddChoice);
		
		/**
		 * This method will depend on the event type; because in open event, every user can only add one choice; in closed
		 * event, moderator add all the event 
		 * @author Hang, Wei
		 */
		//if the add choice button is clicked, add the text to the list
		btnAddChoice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// This event is an open event, then every user can only enter 1 choice
				if(type == "open"){
					if(numChoices < 1) {
						addTextToChoices();
						btnSubmit.setEnabled(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "You can only enter 1 choice in an open event!");
					}
				}
				// This event is a closed event, then moderator add all the choice
				else{
					if(numChoices < maxChoices){
						addTextToChoices();
						// All the choice is added into list, so the submit button can be enabled;
						if(numChoices == maxChoices){
							btnSubmit.setEnabled(true);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "You can only enter " + maxChoices + " choices!");
					}
				}
			}
		});
		
		btnRemoveChoice.setEnabled(false);
		contentPane.add(btnRemoveChoice);
		
		//if the remove choice button is clicked, remove the text from the list
		btnRemoveChoice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(numChoices > 0) {
					removeTextFromChoices();
				}
				else {
					JOptionPane.showMessageDialog(null, "There is nothing to remove!");
				}
			}
		});
	}

	/**
	 * Returns a list of choices
	 * @return Vector<String>
	 */
	public List getChoices() {
		return itemList;
	}
	
	/**
	 * Adds the new choice to the list box
	 */
	public void addTextToChoices() {
		if(!txtEditField.getText().equals("")) {
			currentItem = txtEditField.getText();
			itemList.add(currentItem);
			
			numChoices++;
		
			if(numChoices == maxChoices) {
				btnSubmit.setEnabled(true);
				btnAddChoice.setEnabled(false);
			}
		}
	}
	
	/**
	 * Removes a choice from the list box
	 * @author Trevor Hodde
	 */
	public void removeTextFromChoices() {
		itemList.remove(itemList.getSelectedItem());
		numChoices--;
		
		if(numChoices < maxChoices) {
			btnSubmit.setEnabled(false);
			btnAddChoice.setEnabled(true);
		}
	}
}
