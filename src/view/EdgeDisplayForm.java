package view;

import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AddEdgeController;
import controller.AddEdgeResponseController;
import controller.ButtonController;
import model.Model;

/**
 * This class displays edges that are added between two decision lines
 * @author Trevor Hodde
 */
public class EdgeDisplayForm extends JFrame {
	private static final long serialVersionUID = 1L;
	Model model;
	AddEdgeResponseController edgeController; 
	public int nLastXClick;
	public int nLastYClick;
	int[] xCoords;
	JPanel contentPane;

	/**
	 * Constructor for setting up the edge display form
	 * @param m : Model object
	 */
	public EdgeDisplayForm() {
		//creates the form
		setTitle("Decision Lines Event");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//sets the exit button up
		JButton btnExitButton = new JButton("Exit");
		btnExitButton.setBounds(300, 400, 90, 25);
		btnExitButton.addActionListener(new ButtonController(model, 3, this));
		btnExitButton.setVisible(true);
		contentPane.add(btnExitButton);
		contentPane.addMouseListener(new AddEdgeController(this));
	}
	
	public void redraw(){
		this.repaint();
		model.setJFrame(this);
	}
	
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

	//====================================================================
	//This method returns the the option index for the passed x coordinate
	//Rev 1  -M. Peltola   7-Oct-2012 Class created 
	//====================================================================
	public int getClickOptionIndex(int x) {
		int index = 0; //model.nOptionCount+1;

		if (x > 0 && x < xCoords[model.nOptionCount - 1]) {
			while (x > xCoords[index] && index < model.nOptionCount-1) {
				index++;
			}
		}

		return index - 1;
	}

	//====================================================================
	//This method draws the options, vertical lines, and any added edges
	//Rev 1  -M. Peltola   7-Oct-2012 method created 
	//====================================================================
	public void paintComponent(Graphics g) {
		if (model.nOptionCount > 0) {

			FontMetrics fm = g.getFontMetrics();
			int h = getHeight();

			for (int x = 0; x < model.nOptionCount; x++) {
				if (model.options[x] != null) {

					int lineXCoord = getOptionXCoord(g, x);
					g.drawLine(lineXCoord, 25, lineXCoord, h-55 - fm.getHeight());
					int optionNameWidth = fm.stringWidth(model.options[x]);
					g.drawString(model.options[x], lineXCoord - optionNameWidth / 2, h-55);
				}
			}

			if (model.nextIndex > 0) {
				for (int index = 0; index < model.nextIndex; index++) {
					int optionIndex = model.optionIndices[index];
					int y = model.optionHeights[index];
					if (optionIndex < model.nOptionCount) {
						g.drawLine(xCoords[optionIndex], y, xCoords[optionIndex + 1],y);
					}
					model.setJFrame(this);
				}
			}
		}
	}
}
