
import DLS.model.Model;
import DLS.view.MainForm;

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


