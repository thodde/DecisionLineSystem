package SimpleEdge.view;

import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

import SimpleEdge.controller.AddEdgeController;
import SimpleEdge.model.Model;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Draw edge form, options, and all submitted edges
public class EdgeDisplayPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public Model model;

	public int nLastXClick;
	public int nLastYClick;
	
	private int[] xCoords;
	
	public EdgeDisplayPanel(Model m) {
		model = m;
		
		final EdgeDisplayPanel p = this;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nLastXClick = arg0.getX();
				nLastYClick = arg0.getY();
				
				AddEdgeController addEdgeController = new AddEdgeController(model, p);
				addEdgeController.ProcessEdgeAddition();
			}
		});
	}

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

	public void regenerateOptionXCoords(Graphics g)
	{
		xCoords = new int[model.nOptionCount];
		for (int x = 0; x < model.nOptionCount; x++) {
			xCoords[x] = GetOptionXCoord(g, x);
		}
	}

	public int GetClickOptionIndex(int x) {
		int index = 0; //model.nOptionCount+1;

		if (x > 0 && x < xCoords[model.nOptionCount - 1]) {
			while (x > xCoords[index] && index < model.nOptionCount-1) {
				index++;
			}
		}

		return index - 1;
	}
	
	@Override
	public void paintComponent(Graphics g) {

		if (model != null) {

 			if (model.nOptionCount > 0) {
				
				regenerateOptionXCoords(g);

				FontMetrics fm = g.getFontMetrics();
				int h = getHeight();

				for (int x = 0; x < model.nOptionCount; x++) {
					if (model.options[x] != null) {

						int lineXCoord = GetOptionXCoord(g, x);

						g.drawLine(lineXCoord, 50, lineXCoord, h-25);

						int optionNameWidth = fm.stringWidth(model.options[x]);

						g.drawString(model.options[x], lineXCoord - optionNameWidth / 2, 25);
					}
				}

				if (model.nextIndex > 0) {
					for (int index = 0; index < model.nextIndex; index++) {
						int optionIndex = model.optionIndices[index];
						int y = model.optionHeights[index];
						if (optionIndex < model.nOptionCount) {
							g.drawLine(xCoords[optionIndex], y,
									xCoords[optionIndex + 1],y);
						}
					}
				}

			}
		}
	}
}
