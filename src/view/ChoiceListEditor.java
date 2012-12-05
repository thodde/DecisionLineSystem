package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	JList itemList;
	public String currentItem;
	public Vector<String> currentList;
	JTextField txtEditField;
	JButton btnSubmit;
	JButton btnAddChoice;
	JButton btnRemoveChoice;
	final int maxChoices;
	int numChoices;
	String choice;
	DecisionLinesEvent event = DecisionLinesEvent.getInstance();
	String type = event.getType();
	
	/**
	 * This constructor sets up the GUI for the list editor
	 */
	public ChoiceListEditor(String title, Vector<String> externalList, boolean onlyLastItemAdded, final int maxChoices, Model m) {
		this.currentList = externalList;
		this.model = m;
		this.maxChoices = maxChoices;
		this.numChoices = 0;
		
		setTitle("Event Choices");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//This is the list that holds all of the values
		itemList = new JList(externalList);
	    itemList.setBounds(50, 10, 430, 280);
		itemList.setVisibleRowCount(4);
		itemList.addListSelectionListener(new ValueReporter());
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
		 *
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
						JOptionPane.showMessageDialog(null, "You can only enter 1 choice!");
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
	 * Updates the JList after adding or removing an element
	 * @param externalList : Vector<String> a list of elements to be 
	 * added to the JList
	 */
	public void updateLocalList(Vector<String> externalList){
		itemList.setListData(externalList);
		repaint();
	}

	/**
	 * Returns a list of choices
	 * @return Vector<String>
	 */
	public Vector<String> getChoices(){
		return currentList;
	}
	
	/**
	 * This class adds the selected choice to the text box
	 * and allows the user to remove the item
	 * @author Martti Peltola
	 */
	private class ValueReporter implements ListSelectionListener {
	    public void valueChanged(ListSelectionEvent event) {
	    	if (!event.getValueIsAdjusting()) 
	    		txtEditField.setText("");
	      
	    	btnRemoveChoice.setEnabled(true);
	    }
	}
	
	/**
	 * Bring up the credentials for when the moderator is finished
	 */
	public void loadCredentialsForm() {
		Model model = Model.getModel();
		CredentialsForm cf = new CredentialsForm(model, true);
		cf.setVisible(true);
		this.dispose();
	}
	
	/**
	 * Adds the new choice to the list box
	 */
	public void addTextToChoices() {
		currentItem = txtEditField.getText();
		currentList.add(currentItem);
		updateLocalList(currentList);
		numChoices++;
		
		if(numChoices == maxChoices) {
			btnSubmit.setEnabled(true);
		}
	}
	/**
	 * This method can refresh the choice list, so user in the open event can see the choice being added;
	 * @author Hang, Wei
	 */
	public void refreshChoiceList(){
		Vector<String> vc = new Vector<String>();
		for(int i=0;i<event.getCuri();i++){
			choice = event.getChoice(i);
			vc.add(choice);
			updateLocalList(vc);
			model.setJFrame(this);
		}
	}
	
	/**
	 * Removes a choice from the list box
	 * @author Trevor Hodde
	 */
	public void removeTextFromChoices() {
		if(itemList.getSelectedValue() != null) {
			currentItem = itemList.getSelectedValue().toString();
			if(currentList.contains(currentItem)) {
				currentList.remove(currentItem);
				updateLocalList(currentList);
				numChoices--;
				
				if(numChoices < maxChoices) {
					btnSubmit.setEnabled(false);
				}
			}
		}
	}
}
