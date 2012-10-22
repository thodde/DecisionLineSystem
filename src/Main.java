
import java.awt.Container;
import javax.swing.JButton;

import DLS.model.Model;
import DLS.view.EdgeDisplayPanel;
import DLS.view.MainForm;
import DLS.view.SimpleEdge;

public class Main {
	
	public static void main(String [] args)
	{
		String [] options = {
				"Orange",
				"Mango Tango",
				"Apple",
				"Grape",
				"Apricot",
				"Tomato",
				"Lemon",
				"Pomegranate",
		};
		
		Model m = Model.getModel();
		m.addOptions(options);
		
		MainForm  mainForm = MainForm.getMainForm();
		mainForm.setVisible(true);
		mainForm.SetInitial();
	}
}
