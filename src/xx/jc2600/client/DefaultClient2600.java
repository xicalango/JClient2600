package xx.jc2600.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

import xx.jc2600.client.packet.Packet;

public class DefaultClient2600 implements Runnable, Client2600 {

	private Socket connection;
	private Thread clientThread;
	private boolean running = false;
	
	private Properties connectionInfo;
	
	private Queue<Packet> sendQueue;
	
	public DefaultClient2600(String hostname, int port) {
		connectionInfo = new Properties();
		connectionInfo.setProperty("hostname", hostname);
		connectionInfo.setProperty("port", "" + port);
		
		sendQueue = new LinkedList<>();
	}
	
	@Override
	public void start() {
		
		try {
			
			connection = new Socket(
					connectionInfo.getProperty("hostname"), 
					Integer.valueOf(connectionInfo.getProperty("port"))
				);
			
			clientThread = new Thread(this, "Client2600");
			clientThread.start();
		} catch (NumberFormatException | IOException e) {
			throw new Client2600Exception("connect", e);
		}
		
	}
	
	@Override
	public void run() {
		running = true;
		OutputStream out = null;
		
		try {
			out = connection.getOutputStream();
			
		} catch (IOException e1) {
			e1.printStackTrace();
			running = false;
			clientThread.interrupt();
		}
		
		
		
		while(running && !clientThread.isInterrupted()) {
			
			try {
				Packet nextPacket = getNextPacket();
				
				out.write( new byte[] {nextPacket.getSymbol()} );
				
			} catch (InterruptedException | IOException e) {
				clientThread.interrupt();
			}
			
		}
		
		try {
			out.write( new byte[] { Packet.createQuitPacket().getSymbol() } );
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void stop() {
		running = false;
		clientThread.interrupt();
	}

	private synchronized Packet getNextPacket() throws InterruptedException {
		while(sendQueue.size() == 0) {
			wait();
		}
		
		return sendQueue.poll();
	}


	@Override
	public synchronized void putPacket(Packet p) {
		sendQueue.offer(p);
		notifyAll();
	}
	
	
	
	
	
}
