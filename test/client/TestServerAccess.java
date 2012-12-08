package client;

import junit.framework.TestCase;

public class TestServerAccess extends TestCase {
	public void testServerAccess() {
		ServerAccess sa = new ServerAccess("72.249.186.243", 9371);
		ServerAccess sa2 = new ServerAccess("localhost");
		DebugHandler handler = new DebugHandler();
		
		sa.connect(handler);
		sa2.connect(handler);
		sa.toString();
		sa.getHost();
		sa.isWaiting();
		sa.sendRequest(null);
		sa.sendRequest(null, null);
		sa.disconnect();
	}
}
