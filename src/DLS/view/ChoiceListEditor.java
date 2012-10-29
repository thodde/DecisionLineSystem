package DLS.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DLS.Controller.View.JListTxtFriendListener;


//====================================================================
//This class provides the GUI elements of the choice list editor panel
//Rev 1  -M. Peltola   28-Oct-2012 Class created 
//====================================================================	
public class ChoiceListEditor extends JPanel{

	public final int AllItems = -1;

	private JList itemList;

	private boolean allowListEditing;
	private boolean addOnlyLastItem;
	private JTextField txtEditField;
	private JButton btnSubmit;
	private String[] localList;

	//====================================================================
	//The constructor creates the choice list editor
	// it is also used for adding chocies in open events and displayying final choice order
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public ChoiceListEditor(String title, String[] externalList, boolean allowEditing, boolean onlyLastItemAdded){

		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));		
		setBorder(BorderFactory.createTitledBorder(title));

		allowListEditing = allowEditing;
		addOnlyLastItem = onlyLastItemAdded;

		itemList = new JList(externalList);
		itemList.setBounds(10,20, 420,160);
		itemList.setVisibleRowCount(4);

		
		itemList.addListSelectionListener(new ValueReporter());


		add(itemList);

		JLabel label1 = new JLabel("Add/Edit");
		label1.setBounds(10, 190, 100, 35);
		label1.setVisible(allowListEditing);
		add(label1);

		txtEditField = new JTextField();
		txtEditField.setBounds(100, 190, 240, 35);
		txtEditField.setVisible(allowListEditing);
		txtEditField.addKeyListener(new JListTxtFriendListener(itemList));
		
		
		
		add(txtEditField);

		btnSubmit = new JButton("submit");
		btnSubmit.setBounds(350, 190, 80, 35);
		btnSubmit.setVisible(allowListEditing);
		add(btnSubmit);
	}

	//====================================================================
	// Allow updatng the list displayed
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public void updateLocalList(String[] externalList	){

		itemList = new JList(externalList);
		repaint();
	}

	//====================================================================
	//return choices
	// note only stub at moment
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public String [] getChoices(){
		
		// add code to extract from JList
		String [] theChoiceList = {
				"Mango",
				"Apple",
				"Grape",
				"Pomegranate"};
				
				//return localList;
				return theChoiceList;
	}
	
	
	
	
	private class ValueReporter implements ListSelectionListener {
	    public void valueChanged(ListSelectionEvent event) {
	      if (!event.getValueIsAdjusting()) 
	    	  txtEditField.setText(itemList.getSelectedValue().toString());
	    }
	  }
	
	
}
