package model;

import client.ServerAccess;

/**
 * This class is used to store the Server acess, and make it to singleton, so it will be easier to get the access state
 * @author Hang, Wei
 *
 */

public class Access {
	
	static Access instance = null;
	ServerAccess access;
		
	public static Access getInstance() {
		if (instance == null) {
			instance = new Access();
		}
		
		return instance;
	}
	
	public void setAccess(ServerAccess sa) {
		this.access = sa;
	}
	
	public ServerAccess getAccess() {
		return access;
	}
	
}
