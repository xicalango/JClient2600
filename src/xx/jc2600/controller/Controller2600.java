package xx.jc2600.controller;

import xx.jc2600.client.packet.ButtonType;

public interface Controller2600 {

	void startApplication(String hostname, int port);
	void quitApplication();
	void keyPress( ButtonType button );
	void keyRelease( ButtonType button );
	
}
