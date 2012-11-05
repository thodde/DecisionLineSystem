package view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//====================================================================
//This class provides the  GUI elements which inform the user of
//DLS status and requested command status 
//Rev 1  -M. Peltola   18-Oct-2012 Class created 
//====================================================================
public class StatusPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private boolean normal;
	String statusMessage;

	public StatusPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));		
		setBorder(BorderFactory.createTitledBorder("Status"));

		setLayout(null);
		normal = false;
		statusMessage = "Hello";
	}

	//====================================================================
	//Update the status line and 'LED'
	//Rev 1  -M. Peltola   18-Oct-2012 Class created 
	//====================================================================
	public void updateStatus(boolean status, String statusMsg)
	{
		normal = status;
		statusMessage = statusMsg;
		repaint();
	}

	@Override
	//====================================================================
	//Draws the status line and 'LED'
	//Rev 1  -M. Peltola   18-Oct-2012 Method created 
	//Rev 2  -M. Peltola   21-Oct-2012 adjust text and 'LED' location 
	//====================================================================
	public void paintComponent(Graphics g) {

		Rectangle bounds = getBounds();
        g.clearRect(bounds.x, bounds.y, bounds.width, bounds.height);
        
		if(normal)
		{
			g.setColor(Color.LIGHT_GRAY);
		}
		else
		{
			g.setColor(Color.RED);
		}

		FontMetrics fm = g.getFontMetrics();
		int sh = fm.getHeight();

		int h = getHeight();

		int y = bounds.height/2;

		// Center the 'LED' and 'fudge' it down 3 to clear boundary title
		g.fillOval(y,(3+y/2),y,y);

		g.setColor(Color.BLACK);
		g.drawString(statusMessage, 60, h-sh);
	}
}
