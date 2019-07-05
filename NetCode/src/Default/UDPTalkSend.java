package Default;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPTalkSend implements Runnable{
	private DatagramSocket socket;
	private int port;
	private String toIP;
	private int toPort;
	private byte[] container;
	private BufferedReader reader;
	private String msg;
	
	public UDPTalkSend(int port,String toIP,int toPort) {
		this.port=port;
		try {
			socket=new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		this.toIP=toIP;
		this.toPort=toPort;
		container=new byte[1024*64];
		reader=new BufferedReader(new InputStreamReader(System.in));
		msg="";
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				msg=reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			container=msg.getBytes();
			DatagramPacket packet=new DatagramPacket(container,0,container.length,new InetSocketAddress(toIP,toPort));
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(msg.equals("bye")) {
				break;
			}
			
		}
		socket.close();
		
	}
}
