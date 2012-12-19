package xx.jc2600.client;

import xx.jc2600.client.packet.Packet;

public interface PacketSink {

	void putPacket(Packet p);

}