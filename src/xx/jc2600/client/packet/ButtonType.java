package xx.jc2600.client.packet;

import java.awt.event.KeyEvent;

public enum ButtonType implements PacketData {
	BT_UP((byte) 0x0),
	BT_DOWN((byte) 0x1),
	BT_LEFT((byte) 0x2),
	BT_RIGHT((byte) 0x3),
	BT_BUTTON((byte) 0x4);

	private byte symbol;
	
	private ButtonType(byte symbol) {
		this.symbol = symbol;
	}

	@Override
	public byte getSymbol() {
		return symbol;
	}
	
	public static ButtonType fromKeyEvent(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			return BT_UP;
		case KeyEvent.VK_DOWN:
			return BT_DOWN; 
		case KeyEvent.VK_LEFT:
			return BT_LEFT;
		case KeyEvent.VK_RIGHT:
			return BT_RIGHT;
		case KeyEvent.VK_SPACE:
			return BT_BUTTON;
		default:
			return null;
		}
		
	}
	
}