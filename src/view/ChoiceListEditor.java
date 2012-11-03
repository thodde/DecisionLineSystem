package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ChoiceListEditor extends JPanel{

	private static final long serialVersionUID = 1L;

	public final int AllItems = -1;

	private JList itemList;

	private boolean allowListEditing;
	private boolean addOnlyLastItem;
	private JTextField txtEditField;
	
	private String[] localList;

	//====================================================================
	//The constructor creates the choice list editor
	// it is also used for adding chocies in open events and displaying final choice order
	//Rev 1  -M. Peltola   28-Oct-2012 Class created 
	//====================================================================
	public ChoiceListEditor(String title, String[] externalList, boolean allowEditing, boolean onlyLastItemAdded){

		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));		
		setBorder(BorderFactory.createTitledBorder(title));

		allowListEditing = allowEditing;
		addOnlyLastItem = onlyLastItemAdded;

		itemList = new JList(externalList);
	    itemList.setBounds(50,10, 420,280);
		itemList.setVisibleRowCount(4);
		
		itemList.addListSelectionListener(new ValueReporter());

		add(itemList);

		txtEditField = new JTextField();
		txtEditField.setBounds(20, 300, 240, 35);
		txtEditField.setVisible(allowListEditing);
		txtEditField.setColumns(10);
		
		add(txtEditField);
	}

	public void updateLocalList(String[] externalList	){

		itemList = new JList(externalList);
		repaint();
	}

	public String [] getChoices(){
		String [] theChoiceList = {
				"Mango",
				"Apple",
				"Grape",
				"Pomegranate"};
				
				return theChoiceList;
	}
	
	private class ValueReporter implements ListSelectionListener {
	    public void valueChanged(ListSelectionEvent event) {
	      if (!event.getValueIsAdjusting()) 
	    	  txtEditField.setText(itemList.getSelectedValue().toString());
	    }
	}
}
