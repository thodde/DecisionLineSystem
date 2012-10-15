
import SimpleEdge.model.Model;
import SimpleEdge.view.EdgeDisplayPanel;
import SimpleEdge.view.SimpleEdge;


public class Main {
	public static void main(String [] args)
	{
		/*
		String [] options2 = {"X","Y","Z"};
		String [] options = new String [7];
		
		options[0] = "Orange";
		options[1] = "Mango Tango";
		options[2] = "Apple";
		options[3] = "Grape";
		options[4] = "Apricot";
		options[5] = "Tomato";
		*/
		
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
		

		Model m = new Model(options);
		
		SimpleEdge p = new SimpleEdge(m);
		
		p.setVisible(true);
		
		
	}

}
