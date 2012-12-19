package xx.jc2600.client.packet;

public class Packet implements PacketData {
	
	private byte symbol;
	
	private Packet(byte symbol) {
		this.symbol = symbol;
	}

	@Override
	public byte getSymbol() {
		return symbol;
	}

	public static Packet createQuitPacket() {
		return new Packet(MessageType.MT_QUIT.getSymbol());
	}
	
	public static Packet createButtonPacket( ButtonEventType evType, ButtonType bType ) {
		
		byte symbol = 0;
		
		symbol |= MessageType.MT_BUTTON.getSymbol();
		
		symbol |= evType.getSymbol() << 2;
		symbol |= bType.getSymbol() << 3;
		
		return new Packet(symbol);
	}
	
}
