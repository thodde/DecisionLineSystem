package DLS.view;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import DLS.Controller.View.AddEdgeController;
import DLS.model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

//====================================================================
//This class draws the edge form, options, and all submitted edges
//Rev 1  -M. Peltola   7-Oct-2012 Class created 
//====================================================================
public class EdgeDisplayPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Model model;

	private AddEdgeController edgeController; 
	
	public int nLastXClick;
	public int nLastYClick;

	private int[] xCoords;


	//====================================================================
	//The constructor does the work of setting up the UI elements
	//which capture a user adding of edges 
	//Rev 1  -M. Peltola   7-Oct-2012 Method created 
	//Rev 2  -M. Peltola   21-Oct-2012 Moved exit button to panel 
	//                                 Made edgeController persist for 
	//                                 life of this panel
	//====================================================================
	public EdgeDisplayPanel(Model m, boolean moderator) {
		model = m;

		setLayout(null);
		setBounds(10,65,580,500);
				
		Rectangle r = MainForm.getMainForm().getBounds();
		Rectangle r1 = getBounds();
		int h = getHeight();
		
		// Hard coded exit button location
		int y2 = h-25;
		JButton btnExitButton = new JButton("Exit");
		btnExitButton.setBounds(270, y2, 89, 23);
		btnExitButton.setVisible(true);
		add(btnExitButton);
		
		btnExitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				closeFrame();
			} 
		});
		
		edgeController = new AddEdgeController(model, this);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nLastXClick = arg0.getX();
				nLastYClick = arg0.getY();
				edgeController.processEdgeAddition();
			}
		});
	}
	
	/**
	 * Make sure the user can exit the form if they choose to do so
	 */
	public void closeFrame() {
		JFrame frame = (JFrame) this.getTopLevelAncestor();
		frame.dispose();
	}

	//====================================================================
	//This method returns the X Coord of the option index
	//Rev 1  -M. Peltola   7-Oct-2012 Class created 
	//====================================================================
	public int GetOptionXCoord(Graphics g, int optionIndex) {
		int xCoord = 0;

		if (model != null) {

			if (model.nOptionCount > 0) {
				int w = getWidth();

				// border width
				int bw = 45;
				int rw = w - 2 * bw;

				if (model.nOptionCount > 1) {
					int t = model.nOptionCount - 1;

					int nSpacing = rw / t;
					xCoord = bw + optionIndex * nSpacing;
				}
			}
		}

		return xCoord;
	}

	//====================================================================
	//This method regenerates the X Coords of the options
    // if the app has been resized
	//Rev 1  -M. Peltola   7-Oct-2012 Class created 
	//====================================================================
	public void regenerateOptionXCoords(Graphics g)
	{
		xCoords = new int[model.nOptionCount];
		for (int x = 0; x < model.nOptionCount; x++) {
			xCoords[x] = GetOptionXCoord(g, x);
		}
	}

	//====================================================================
	//This method returns the the option index for the passed x coordinate
	//Rev 1  -M. Peltola   7-Oct-2012 Class created 
	//====================================================================
	public int GetClickOptionIndex(int x) {
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
	@Override
	public void paintComponent(Graphics g) {

		if (model != null) {

			String clickCoord = "X= " + model.nLastXClick+ "  Y= " + model.nLastYClick;

			Rectangle r1 = getBounds();

			if (model.nOptionCount > 0) {

				regenerateOptionXCoords(g);

				FontMetrics fm = g.getFontMetrics();
				int h = getHeight();

				for (int x = 0; x < model.nOptionCount; x++) {
					if (model.options[x] != null) {

						int lineXCoord = GetOptionXCoord(g, x);

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
					}
				}
			}
		}
	}
}
