package xx.jc2600.controller;

import xx.jc2600.client.Client2600;
import xx.jc2600.client.DefaultClient2600;
import xx.jc2600.client.packet.ButtonEventType;
import xx.jc2600.client.packet.ButtonType;
import xx.jc2600.client.packet.Packet;

public class DefaultController2600 implements Controller2600 {

	private Client2600 client2600;
	
	public DefaultController2600() {
	}
	
	@Override
	public void startApplication(String hostname, int port) {
		client2600 = new DefaultClient2600(hostname, port);
		client2600.start();
	}
	
	@Override
	public void quitApplication() {
		client2600.stop();
	}

	@Override
	public void keyPress(ButtonType button) {
		Packet p = Packet.createButtonPacket( ButtonEventType.BE_PRESS, button);
		client2600.putPacket(p);
	}

	@Override
	public void keyRelease(ButtonType button) {
		Packet p = Packet.createButtonPacket( ButtonEventType.BE_RELEASE, button);
		client2600.putPacket(p);
	}



}
