package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;

public class AddOpenEventChoice extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField questionTextField;
	JPanel questionPanel;
	ChoiceListEditor listEditor;
	Model model;

	public AddOpenEventChoice(String EventID, String question, Vector<String> existingChoices, Model m) {
		this.model = m;
		setBounds(1,1,550,555);
		setLayout(null);

		questionPanel = new JPanel();
		questionPanel.setBounds(1, 70, 609, 93);
		questionPanel.setBorder(BorderFactory.createTitledBorder("Event Question"));
		questionPanel.setLayout(new BorderLayout(0, 0));
		add(questionPanel);

		questionTextField = new JTextField();
		questionTextField.setForeground(Color.BLACK);
		questionTextField.setEnabled(false);
		questionTextField.setText(question);
		questionTextField.repaint();
		
		questionPanel.add(questionTextField, BorderLayout.CENTER);
		questionTextField.setColumns(10);

		
		listEditor = new ChoiceListEditor("Existing Choices", existingChoices, true, model);
		listEditor.setBounds(45, 190, 450, 435);
		add(listEditor);
		
		repaint();
	}
}
