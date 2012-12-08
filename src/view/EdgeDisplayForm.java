package view;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AddEdgeController;
import controller.AddEdgeResponseXMLController;
import controller.ButtonController;
import model.DecisionLinesEvent;
import model.Edge;
import model.Model;

/**
 * This class displays edges that are added between two decision lines
 * @author Trevor Hodde
 */
public class EdgeDisplayForm extends JFrame {
	private static final long serialVersionUID = 1L;
	Model model;
	AddEdgeResponseXMLController edgeController; 
	public int nLastXClick;
	public int nLastYClick;
	public static final int CHOICEWIDTH = 100;
	public static final int CHOICEHEIGHT = 55;
	int[] xCoords;
	JPanel contentPane;

	/**
	 * Constructor for setting up the edge display form
	 * @param m : Model object
	 */
	public EdgeDisplayForm() {
		model = Model.getModel();
		//creates the form
		setTitle("Decision Lines Event");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700, 500);
		
		setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//sets the exit button up
		JButton btnExitButton = new JButton("Exit");
		btnExitButton.setBounds(300, 400, 90, 25);
		btnExitButton.addActionListener(new ButtonController(3, this));
		btnExitButton.setVisible(true);
		contentPane.add(btnExitButton);
		contentPane.addMouseListener(new AddEdgeController(this));
		
		model.setJFrame(this);
	}
	
	public void redraw(){
		this.repaint();
		model.setJFrame(this);
	}
	/*
	public int getOptionXCoord(Graphics g, int optionIndex) {
		int xLeft = 0;

		if (model.nOptionCount > 0) {
			int w = getWidth();

			// border width
			int bw = 45;
			int rw = w - 2 * bw;

			if (model.nOptionCount > 1) {
				int t = model.nOptionCount - 1;

				int nSpacing = rw / t;
				xLeft = bw + optionIndex * nSpacing;
				Model.Left = xLeft;
				Model.Right = xLeft + nSpacing;
			}
		}

		return xLeft;
	}

	public int getClickOptionIndex(int x) {
		int index = 0;

		if (x > 0 && x < xCoords[model.nOptionCount - 1]) {
			while (x > xCoords[index] && index < model.nOptionCount-1) {
				index++;
			}
		}

		return index - 1;
	}
	*/
	
	/**
	 * Returns the position of the current choice line
	 * @param choicePosition int
	 * @return int position of choice line
	 */
	public int getChoiceXLocation(int choicePosition) {
		return choicePosition * CHOICEWIDTH + 20;
	}
	
	/**
	 * Return the length of the current choice line
	 * @param choicePosition int
	 * @return int height of choice line
	 */
	public int getChoiceYLocation(int choicePosition) {
		return CHOICEHEIGHT;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Edge currentEdge;
		
		DecisionLinesEvent event = model.getDecisionLinesEvent();
		for (int i = 0; i < event.choices.length; i++) {
			g.drawString(event.choices[i], getChoiceXLocation(i), getChoiceYLocation(i));
			g.drawLine(getChoiceXLocation(i) + 20, getChoiceYLocation(i) + 10, getChoiceXLocation(i) + 20, getChoiceYLocation(i) + 350);
		}
		
		for(int i = 0; i < event.getEdges().size(); i++) {
			currentEdge = event.getEdges().get(i);
			g.drawLine(getChoiceXLocation(currentEdge.getLeft()) + 20, currentEdge.getHeight() + 10, getChoiceXLocation(currentEdge.getRight()) + 20, currentEdge.getHeight() + 10);
		}
	}
}
