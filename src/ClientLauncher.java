import model.Access;
import model.Model;
import client.ClientMessageHandler;
import client.DebugHandler;
import client.ServerAccess;
import view.MainForm;
import xml.Message;

/** 
 * Launch command-line Client to show minimal access needs. 
 * This class has mostly been borrowed from the Professor
 */
public class ClientLauncher {

	// If requested by ClientLauncher (pass in '-server' as argument).
	//public static final String serverHost = "72.249.186.243";
	public static final String serverHost = "192.168.1.9";
	
	//default port number
	public static int defaultPort = 9371;
	
	/**
	 * Note that to simplify the coding of this command-client, it declares that it can throw an Exception,
	 * which is typically the failed connection to a server.
	 */
	public static void main(String[] args) throws Exception {
		// FIRST thing to do is register the protocol being used. There will be a single class protocol
		// that will be defined and which everyone will use. For now, demonstrate with skeleton protocol.
		if (!Message.configure("draw2choose.xsd")) {
			System.exit(0);
		}
		
		Model model = Model.getModel();
		MainForm mf = new MainForm(model);
		mf.setVisible(true);
		
		// select dedicated server with '-server' options
		String host = "localhost";
		if (args.length > 0 && args[0].equals("-server")) {
			host = serverHost;
		}
		host = serverHost;
		
		int port = 9371;
		if(args.length > 0 && args[1].equals("-port")) {
			port = defaultPort;
		}
		
		// create message chain
		//DebugHandler handler = new DebugHandler();
		ClientMessageHandler handler = new ClientMessageHandler();
		
		// try to connect to the server. Once connected, messages are going to be processed by 
		// SampleClientMessageHandler. For now we just continue on with the initialization because
		// no message is actually sent by the connect method.		
		ServerAccess sa = new ServerAccess(host, port);
		if (!sa.connect(handler)) {
			System.out.println("Unable to connect to server (" + host + "). Exiting.");
			System.exit(0);
		}
		System.out.println("Connected to " + host);
		
		
		// send an introductory connect request now that we have created (but not made visible!)
		// the GUI
		
		// set the ac to the global value
		Access ac = Access.getInstance();
		ac.setAccess(sa);
		
		String xmlString = Message.requestHeader() + "<connectRequest/></request>";
		Message m = new Message (xmlString);
		sa.sendRequest(m);
	} 
}
