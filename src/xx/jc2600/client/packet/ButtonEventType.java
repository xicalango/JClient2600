package xx.jc2600.client.packet;

public enum ButtonEventType implements PacketData {
	BE_PRESS((byte) 0x0),
	BE_RELEASE((byte) 0x1);

	private byte symbol;
	
	private ButtonEventType(byte symbol) {
		this.symbol = symbol;
	}



	@Override
	public byte getSymbol() {
		return symbol;
	}
	
}