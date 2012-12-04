import junit.framework.TestCase;

public class TestClient extends TestCase {
	public void testClient() throws Exception {
		ClientLauncher cl = new ClientLauncher();
		String[] args = new String[1];
		args[0] = "";
		cl.main(args);
	}
}
