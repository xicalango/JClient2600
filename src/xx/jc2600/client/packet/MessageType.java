package xx.jc2600.client.packet;

public enum MessageType implements PacketData {
	MT_BUTTON((byte) 0x0),
	MT_QUIT((byte) 0x1);

	private byte symbol;
	
	private MessageType(byte symbol) {
		this.symbol = symbol;
	}

	@Override
	public byte getSymbol() {
		return symbol;
	}
}