package xx.jc2600.controller;

import xx.jc2600.client.Client2600;
import xx.jc2600.client.Client2600Exception;
import xx.jc2600.client.DefaultClient2600;
import xx.jc2600.client.packet.ButtonEventType;
import xx.jc2600.client.packet.ButtonType;
import xx.jc2600.client.packet.Packet;

public class DefaultController2600 implements Controller2600 {

	private Client2600 client2600 = null;
	
	public DefaultController2600() {
	}
	
	@Override
	public void connect(String hostname, int port) {
		client2600 = new DefaultClient2600(hostname, port);
		try {
			client2600.start();
		} catch ( Client2600Exception e) {
			client2600 = null;
			throw e;
		}
	}
	
	@Override
	public void disconnect() {
		if(isConnected()) {
			client2600.stop();
			client2600 = null;
		}
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

	@Override
	public boolean isConnected() {
		return client2600 != null;
	}

	@Override
	public void connect(String connectionString) {
		String[] split = connectionString.split(":");
		
		if(split.length == 1) {
			connect(connectionString, 2600);
		} else if(split.length == 2) {
			connect(split[0], Integer.valueOf(split[1]));
		} else {
			throw new IllegalArgumentException("connectionString");
		}
	}



}
