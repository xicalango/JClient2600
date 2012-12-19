package xx.jc2600.controller;

import xx.jc2600.client.packet.ButtonType;

public interface Controller2600 {

	void connect(String hostname, int port);
	void connect(String connectionString);
	void disconnect();
	void keyPress( ButtonType button );
	void keyRelease( ButtonType button );
	
	boolean isConnected();
	
}
